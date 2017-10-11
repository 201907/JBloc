package com.shenyang.service.impl;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.shenyang.bean.*;
import com.shenyang.core.HtmlStringFilter;
import com.shenyang.core.StringFilter;
import com.shenyang.dao.BlogMapper;
import com.shenyang.dao.CodeMapper;
import com.shenyang.dao.UserMapper;
import com.shenyang.service.BlogService;
import com.shenyang.utils.BlogCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private CodeMapper codeMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public long getBlogCount(int userId) {
        BlogExample blogExample = new BlogExample();
        blogExample.createCriteria().andUseIdEqualTo(userId);
        return blogMapper.countByExample(blogExample);
    }

    @Override
    public List<Blog> queryNearestBlog(int limit) {

        return blogMapper.queryNearestBlog(limit);
    }

    @Override
    public List<BlogUser> blogCodeInsertBlogContent(List<Blog> blogList) {
        if (blogList == null || blogList.size() == 0)
            Preconditions.checkNotNull(blogList, "博客数据不能为空");
        List<BlogUser> blogContentList = Lists.newArrayList();
        blogList.forEach(blog -> {
            BlogUser blogUser = new BlogUser();
            blogUser.setId(blog.getId());
            blogUser.setCreateDate(blog.getCreateDate());
            blogUser.setModifyDate(blog.getModifyDate());
            blogUser.setTitle(blog.getTitle());
            blogUser.setUser(userMapper.selectByPrimaryKey(blog.getUseId()));
            String content = null;
            CodeExample codeExample = new CodeExample();
            codeExample.createCriteria().andBlogIdEqualTo(blog.getId());
            //查询出博客对应的代码
            List<Code> codeList = codeMapper.selectByExampleWithBLOBs(codeExample);
            if (codeList == null || codeList.size() == 0) {
                blogUser.setContent(blog.getContent());
                blogContentList.add(blogUser);
            } else {
                Collection collection = Collections2.transform(codeList, new Function<Code, String>() {
                    @Override
                    public String apply(Code code) {
                        return code.getCode();
                    }
                });
                BlogCodeUtil blogCodeUtil = new BlogCodeUtil(blog.getContent(), Lists.newArrayList(collection.iterator()));
                blogUser.setContent(blogCodeUtil.getContent());
                blogContentList.add(blogUser);
            }
        });
        return blogContentList;
    }

    /**
     * 添加博客
     *
     * @param title
     * @param content
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addBlog(int userId, String title, String content) {
        int result = 0;
        //将文本中的/r/n转换成<br/>保存数据库
//        StringFilter htmlFilter = new HtmlStringFilter();
//        content = htmlFilter.filter(content);
//        content = HtmlUtils.htmlEscape(content);
        BlogCodeUtil blogCodeUtil = new BlogCodeUtil(content, "input", "code");
        //获得文本中的代码
        List<String> code = blogCodeUtil.getCodeList();
        Blog blog = new Blog();
        blog.setContent(blogCodeUtil.getContentNoCode());
        blog.setTitle(title);
        blog.setUseId(userId);
        blog.setModifyDate(new Date());
        //插入博客数据
        result = blogMapper.insertSelective(blog);
        //获得博客id
        int blogId = blog.getId();
        //获取集合对象
        Collection<Code> list = Collections2.transform(code, new Function<String, Code>() {
            @Override
            public Code apply(String f) {
                Code code = new Code();
                code.setBlogId(blogId);
                code.setCode(f);
                return code;
            }
        });
        List<Code> codeList = Lists.newArrayList(list.iterator());
        //插入代码
        if (codeList != null && codeList.size() != 0) {
            int codeCount = codeMapper.insertCodeList(codeList);
            if (codeCount != 0) {
                result = codeCount;
            }
        }
        return result;
    }

    @Override
    public List<Blog> queryBlogByLimit(int userId, int limit) {
        return blogMapper.queryBlogByLimit(userId, limit);
    }//BaseResultMap
}

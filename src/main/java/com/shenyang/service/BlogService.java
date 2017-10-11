package com.shenyang.service;


import com.shenyang.bean.Blog;
import com.shenyang.bean.BlogUser;

import java.util.List;

public interface BlogService {
    int addBlog(int userId, String title, String content);

    List<Blog> queryBlogByLimit(int userId, int limit);

    List<Blog> queryNearestBlog(int limit);

    long getBlogCount(int userId);

    /**
     * 将blog中的代码嵌入文本
     *
     * @param blogList
     * @return
     */
    List<BlogUser> blogCodeInsertBlogContent(List<Blog> blogList);
}

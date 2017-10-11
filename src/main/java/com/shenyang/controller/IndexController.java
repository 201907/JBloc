package com.shenyang.controller;

import com.shenyang.bean.Blog;
import com.shenyang.bean.BlogUser;
import com.shenyang.bean.User;
import com.shenyang.service.BlogService;
import com.shenyang.service.ShadowInfoService;
import com.shenyang.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {
    private Logger logger = LogManager.getLogger(IndexController.class);
    @Autowired
    private ShadowInfoService shadowInfoService;
    @Autowired
    private UserService userService;
    @Autowired
    private BlogService blogService;

    @RequestMapping("/")
    public String toIndex(Model model) {
        model.addAttribute("encode", shadowInfoService.getShadowsocksEncryCode());
        model.addAttribute("managerName", userService.queryUserByUserid(1).getUserName());
        model.addAttribute("managerBlogCount", "共<a href='/blog/" + 1 + "'>" + blogService.getBlogCount(1) + "</a>篇日志");
        List<Blog> blogList = blogService.queryNearestBlog(5);
        if (blogList == null)
            return "index";
        List<BlogUser> blogContentList = blogService.blogCodeInsertBlogContent(blogList);
        model.addAttribute("blogContentList", blogContentList);
        return "index";
    }

    @RequestMapping("/shadowsocks")
    @ResponseBody
    public String getShadowsocks() {
        return shadowInfoService.getShadowsocksEncryCode();
    }

    @RequestMapping("/blog/index")
    public String toBlog(HttpSession session, Model model) {
        User user = (User) session.getAttribute("login");
        List<Blog> blogList = blogService.queryBlogByLimit(user.getId(), 10);
        if (blogList == null || blogList.size() == 0)
            return "blog/index";
        List<BlogUser> blogContentList = blogService.blogCodeInsertBlogContent(blogList);
        model.addAttribute("blogContentList", blogContentList);
        return "blog/index";
    }

    @RequestMapping("/shenyang/index")
    public String toShenyang() {
        return "shenyang/index";
    }

    @RequestMapping("/home")
    public String toHome(HttpSession session, Model model) {
        User user = (User) session.getAttribute("login");
        String title = user.getUserName() + " | JBloc";
        model.addAttribute("title", title);
        return "home";
    }
}

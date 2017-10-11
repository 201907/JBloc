package com.shenyang.controller;

import com.shenyang.bean.User;
import com.shenyang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RequestMapping("/blog")
@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    /**
     * 添加博客
     *
     * @param code
     * @param title
     * @param content
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String post(@RequestParam(value = "title") String title, @RequestParam(value = "content") String content, HttpSession session) {
        User user = (User) session.getAttribute("login");
        if (blogService.addBlog(user.getId(), title, content) != 0) {
            return "true";
        }
        return "false";
    }
}

package com.shenyang.controller;

import com.shenyang.bean.User;
import com.shenyang.core.PicCacheManager;
import com.shenyang.service.UserService;
import com.shenyang.utils.ImageUtil;
import com.shenyang.utils.MD5Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.net.HttpCookie;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

@Controller
public class UserController {
    private Logger logger = LogManager.getLogger(UserController.class);

    private PicCacheManager picCacheManager = PicCacheManager.getInstance();
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/regist", method = RequestMethod.GET)
    public String toRegist() {
        return "/regist";
    }

    /**
     * 用户注册
     *
     * @param user
     * @param response
     * @param session
     */
    @RequestMapping(value = "/regist", method = RequestMethod.PUT)
    public void userRegist(User user, HttpServletResponse response, HttpSession session) {
        response.setContentType("text/html;charset=utf-8");
        if (userService.userRegist(user) != 0) {
            try {
                user = userService.queryUserByLoginNameAndPwd(user.getLoginName(), user.getPassword());
                //保存用户登录状态
                session.setAttribute("login", user);
                response.getWriter().println("<script>alert('注册成功！');location.href='/';</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            response.getWriter().println("<script>alert('注册失败！');location.href='/';</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 用户登录
     *
     * @param user
     * @param autoLogin
     * @param response
     * @param session
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void userlogin(User user, @RequestParam(value = "auto-login") String autoLogin, HttpServletResponse response, HttpSession session) {
        try {
            user.setPassword(MD5Util.encodeStr(user.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        user = userService.queryUserByLoginNameAndPwd(user.getLoginName(), user.getPassword());
        response.setContentType("text/html;charset=utf-8");
        try {
            if (user != null) {
                session.setAttribute("login", user);
                if (autoLogin.equals("on")) {
                    Cookie loginName = new Cookie("loginName", user.getLoginName());
                    Cookie password = new Cookie("password", user.getPassword());
                    response.addCookie(loginName);
                    response.addCookie(password);
                }
                response.getWriter().println("<script>alert('登录成功！');location.href='/';</script>");
            } else {
                response.getWriter().println("<script>alert('用户名或密码错误！');history.back(-1);</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 注销
     *
     * @param session
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("login");
        return "index";
    }

    /**
     * 判断用户是否存在
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/checkUserIfExists", method = RequestMethod.GET, params = "loginName")
    public String checkUserIfExists(@RequestParam(value = "loginName") String loginName) {
        if (userService.queryUserByLoginName(loginName) != null) return "false";
        return "true";
    }

    /**
     * 返回用户头像
     *
     * @param response
     * @return
     */
    @RequestMapping("/getUserIcon")
    public void getUserIcon(HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        User user = (User) session.getAttribute("login");
        if (user == null) return;
        try {
            byte[] icon = picCacheManager.get(user.getId());
            if (icon == null || icon.length == 0) {
                response.getOutputStream().write(user.getIcon());
            } else {
                response.getOutputStream().write(icon);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从缓存中获取用户临时头像
     *
     * @param session
     * @param response
     */
    @RequestMapping("/getUserTempIcon")
    public void getUseTempIcon(HttpSession session, HttpServletResponse response) {
        int userId = ((User) session.getAttribute("login")).getId();
        try {
            byte[] img = picCacheManager.get(userId);
            response.getOutputStream().write(img);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 获得管理员头像
     *
     * @param response
     */
    @RequestMapping("/getAmainIcon")
    public void getAmainIcon(HttpServletResponse response) {
        int userId = 1;
        byte[] icon = userService.getIcon(userId);
        try {
            response.getOutputStream().write(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传用户头像
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/uploadIcon", method = RequestMethod.POST)
    public boolean uploadIcon(@RequestParam(required = false, value = "file") MultipartFile file, HttpSession session) {
        int userId = ((User) session.getAttribute("login")).getId();
        try {
            byte[] img = file.getBytes();
            if (img != null) {
                picCacheManager.put(userId, img);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    /**
     * 保存用户头像
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveUserIcon", method = RequestMethod.PUT)
    public String saveUserIcon(ImageUtil.ImageSize size, HttpSession session) {
        logger.info(size);
        User user = (User) session.getAttribute("login");
        int userId = user.getId();
        try {
            byte[] img = picCacheManager.get(userId);
            if (img == null || img.length == 0) return "false";
            img = ImageUtil.zoomImage(img, 300, 300);
            if (img == null || img.length == 0) return "false";
            img = ImageUtil.imageClipper(img, size);
            if (img == null || img.length == 0) return "false";
            //保存用户头像至数据库
            if (userService.setUserIcon(userId, img) != 0) {
                //刷新session
                user.setIcon(img);
                //刷新缓存
                picCacheManager.put(userId,img);
                return "true";
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "false";
    }
}

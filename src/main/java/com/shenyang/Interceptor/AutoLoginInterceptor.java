package com.shenyang.Interceptor;

import com.shenyang.bean.User;
import com.shenyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * 拦截器，实现自动登录
 */
public class AutoLoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Cookie[] cookies = httpServletRequest.getCookies();
        HttpSession session = httpServletRequest.getSession();
        String loginName = null;
        String password = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginName")) {
                loginName = cookie.getValue();
            } else if (cookie.getName().equals("password")) {
                password = cookie.getValue();
            }
        }
        User user = userService.queryUserByLoginNameAndPwd(loginName, password);
        if (user != null)session.setAttribute("login",user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

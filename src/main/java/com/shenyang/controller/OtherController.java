package com.shenyang.controller;

import com.shenyang.utils.VeriCodeUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class OtherController {
    private Logger logger = LogManager.getLogger(OtherController.class);

    /**
     * 创建验证码
     *
     * @param response
     * @param session
     */
    @RequestMapping(value = "/veriCode", method = RequestMethod.GET)
    public void createVeriCodeImg(HttpServletResponse response, HttpSession session) {
        try {
            VeriCodeUtil veriCodeUtil = new VeriCodeUtil();
            session.setAttribute("veriCode", veriCodeUtil.createVerifiCodeImage(response.getOutputStream(), 70, 35));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 验证验证码
     *
     * @param veriCode
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/checkVeriCode", method = RequestMethod.GET, params = "verificationCode")
    public String checkVeriCode(@RequestParam(value = "verificationCode", required = true) String veriCode, HttpSession session) {
        try {
            String sessionVeriCode = (String) session.getAttribute("veriCode");
            if (sessionVeriCode.equalsIgnoreCase(veriCode)) {
                return "true";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "false";
    }
}

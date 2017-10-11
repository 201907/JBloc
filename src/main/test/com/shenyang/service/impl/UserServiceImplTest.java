package com.shenyang.service.impl;

import com.google.common.io.Files;
import com.shenyang.MainApplication;
import com.shenyang.bean.User;
import com.shenyang.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void userRegist() throws Exception {
        User user = new User();
        user.setLoginName("test6");
        user.setPassword("abc123");
        userService.userRegist(user);
    }

    @Test
    public void testInsertIcon() {
        int id = 1;
        try {
            byte[] icon = Files.toByteArray(new File("C:\\Users\\Administrator\\Desktop\\笔记\\yome.png"));
            userService.setUserIcon(id, icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
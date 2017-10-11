package com.shenyang.service.impl;

import com.shenyang.MainApplication;
import com.shenyang.service.ShadowInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class ShadowInfoServiceImplTest {
    @Autowired
    private ShadowInfoService shadowInfoService;
    @Test
    public void test(){
        String str = shadowInfoService.getShadowsocksEncryCode();
        System.out.println(str);
    }
}
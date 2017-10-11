package com.shenyang.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmailUtilTest {
    @Test
    public void test(){
        String str = "2543487276@.com";
        System.out.println(EmailUtil.checkEmailFormat(str));
    }
}
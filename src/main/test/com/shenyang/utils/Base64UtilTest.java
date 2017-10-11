package com.shenyang.utils;

import org.junit.Test;

public class Base64UtilTest {
    @Test
    public void test() {
        String str = "chacha20:201907@192.168.100.1:8888";
        System.out.println(Base64Util.encodeStr(str));
    }

}
package com.shenyang.utils;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

public class MD5UtilTest {
    @Test
    public void test(){
        try {
            System.out.println(MD5Util.encodeStr("z18721402906sc"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
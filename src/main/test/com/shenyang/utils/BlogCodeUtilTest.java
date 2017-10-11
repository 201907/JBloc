package com.shenyang.utils;

import com.google.common.base.Joiner;
import com.google.common.io.Files;
import com.shenyang.bean.Code;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import static org.junit.Assert.*;

public class BlogCodeUtilTest {
//    String content=null;
    private BlogCodeUtil blogCodeUtil;
    public BlogCodeUtilTest() {
        try {
//            System.out.println(new File(Thread.currentThread().getContextClassLoader().getResource("test.txt").getPath()).getAbsolutePath());
            List<String>lines = Files.readLines(new File(Thread.currentThread().getContextClassLoader().getResource("test.txt").getPath()), Charset.defaultCharset());
            String content= Joiner.on("").join(lines);
            blogCodeUtil = new BlogCodeUtil(content,"input","code");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setContent() throws Exception {
//        System.out.println(content);
//        BlogCodeUtil blogCodeUtil = new BlogCodeUtil(content,"input","code");

    }

    @Test
    public void setContent1() throws Exception {
    }

    @Test
    public void getContent() throws Exception {
    }

    @Test
    public void getContentNoCode() throws Exception {
    }

    @Test
    public void getCodeList() throws Exception {
        List<String>codeList = blogCodeUtil.getCodeList();
        System.out.println(MD5Util.encodeStr(codeList.get(1)));
    }

}
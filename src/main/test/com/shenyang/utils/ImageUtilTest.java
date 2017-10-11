package com.shenyang.utils;

import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class ImageUtilTest {
    @Test
    public void zoomImage() throws Exception {
        byte[] image = Files.toByteArray(new File("C:\\Users\\Administrator\\Desktop\\笔记\\yome.png"));
        byte[] image2 = ImageUtil.zoomImage(image, 500, 500);
        Files.write(image2,new File("C:\\Users\\Administrator\\Desktop\\笔记\\yome2.png"));
    }

    @Test
    public void getImgFormat() throws Exception {
    }

    @Test
    public void imageClipper() throws Exception {
    }

    @Test
    public void imageClipper1() throws Exception {
    }

}
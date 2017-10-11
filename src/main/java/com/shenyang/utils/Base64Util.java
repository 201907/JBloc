package com.shenyang.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Base64加解密工具类
 */
public class Base64Util {
    private Base64Util() {
    }


    /**
     * Base64加密
     *
     * @param str
     * @return
     */
    public static String encodeStr(String str) {
        BASE64Encoder encoder = new BASE64Encoder();
        return new String(encoder.encode(str.getBytes()));
    }

    /**
     * Base解密
     *
     * @param str
     * @return
     * @throws IOException
     */
    public static String decodeStr(String str) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        return new String(decoder.decodeBuffer(str));
    }
}

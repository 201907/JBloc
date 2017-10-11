package com.shenyang.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtil {
    private EmailUtil() {
    }

    /**
     * 检测邮箱格式
     *
     * @param mail
     * @return
     */
    public static boolean checkEmailFormat(String mail) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
        Matcher matcher = pattern.matcher(mail);
        if (matcher.find()) return true;
        return false;
    }
}

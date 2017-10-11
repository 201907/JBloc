package com.shenyang.service;

import com.shenyang.bean.User;
import com.shenyang.utils.ImageUtil;

public interface UserService {
    User queryUserByLoginNameAndPwd(String loginName, String password);

    User queryUserByLoginName(String loginName);

    int userRegist(User user);

    byte[] getIcon(int userId);

    int setUserIcon(int userId, byte[] icon);

    User queryUserByUserid(int userId);
}

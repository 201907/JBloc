package com.shenyang.service.impl;

import com.shenyang.bean.User;
import com.shenyang.bean.UserExample;
import com.shenyang.dao.UserMapper;
import com.shenyang.service.UserService;
import com.shenyang.utils.Base64Util;
import com.shenyang.utils.EmailUtil;
import com.shenyang.utils.ImageUtil;
import com.shenyang.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     *
     * @param loginName
     * @param password
     * @return
     */
    @Override
    public User queryUserByLoginNameAndPwd(String loginName, String password) {
        User user = null;
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginNameEqualTo(loginName).andPasswordEqualTo(password);
        List<User> userList = userMapper.selectByExampleWithBLOBs(userExample);
        if (userList != null && userList.size() != 0) user = userList.get(0);
        return user;
    }

    /**
     * 根据登录名判断用户是否存在
     *
     * @param loginName
     * @return
     */
    @Override
    public User queryUserByLoginName(String loginName) {
        User user = null;
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginNameEqualTo(loginName);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList != null && userList.size() != 0) user = userList.get(0);
        return user;
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int userRegist(User user) {
        int result = 0;
        try {
            //用户验证
            if (user.getLoginName() == null || user.getLoginName().length() < 5 || user.getLoginName().length() > 20)
                return 0;
            if (queryUserByLoginName(user.getLoginName()) != null) return 0;
            if (user.getPassword() == null || user.getPassword().length() < 5 || user.getPassword().length() > 20)
                return 0;
            if (user.getEmail() != null) {
                if (!EmailUtil.checkEmailFormat(user.getEmail())) return 0;
            }
            //根据用户登录名Base加密生成用户名
            user.setUserName(Base64Util.encodeStr(user.getLoginName()));
            user.setPassword(MD5Util.encodeStr(user.getPassword()));
            result = userMapper.insertSelective(user);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据用户id查询用户
     *
     * @param userId
     * @return
     */
    @Override
    public User queryUserByUserid(int userId) {
        User user = null;
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(userId);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList != null && userList.size() != 0) user = userList.get(0);
        return user;
    }

    /**
     * 根据用户ID查询头像
     *
     * @param userId
     * @return
     */
    @Override
    public byte[] getIcon(int userId) {
        User user = null;
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(userId);
        List<User> userList = userMapper.selectByExampleWithBLOBs(userExample);
        if (userList != null && userList.size() != 0) user = userList.get(0);
        return user.getIcon();
    }

    /**
     * 设置用户头像
     *
     * @param userId
     * @param icon
     * @return
     */
    @Transactional
    @Override
    public int setUserIcon(int userId, byte[] icon) {
        User user = new User();
        user.setId(userId);
        user.setIcon(icon);
        return userMapper.updateByPrimaryKeySelective(user);
    }
}

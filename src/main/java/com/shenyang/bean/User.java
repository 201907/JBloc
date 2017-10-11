package com.shenyang.bean;

import java.util.Date;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.id
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.login_name
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    private String loginName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.user_name
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.password
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.email
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.create_date
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.point
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    private Integer point;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.level
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    private Integer level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.icon
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    private byte[] icon;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.id
     *
     * @return the value of USER.id
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.id
     *
     * @param id the value for USER.id
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.login_name
     *
     * @return the value of USER.login_name
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.login_name
     *
     * @param loginName the value for USER.login_name
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.user_name
     *
     * @return the value of USER.user_name
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.user_name
     *
     * @param userName the value for USER.user_name
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.password
     *
     * @return the value of USER.password
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.password
     *
     * @param password the value for USER.password
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.email
     *
     * @return the value of USER.email
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.email
     *
     * @param email the value for USER.email
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.create_date
     *
     * @return the value of USER.create_date
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.create_date
     *
     * @param createDate the value for USER.create_date
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.point
     *
     * @return the value of USER.point
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public Integer getPoint() {
        return point;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.point
     *
     * @param point the value for USER.point
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public void setPoint(Integer point) {
        this.point = point;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.level
     *
     * @return the value of USER.level
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.level
     *
     * @param level the value for USER.level
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.icon
     *
     * @return the value of USER.icon
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public byte[] getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.icon
     *
     * @param icon the value for USER.icon
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public void setIcon(byte[] icon) {
        this.icon = icon;
    }
}
package com.shenyang.bean;

import java.util.Date;

public class BlogUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BLOG.id
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BLOG.create_date
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BLOG.modify_date
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    private Date modifyDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BLOG.title
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BLOG.use_id
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BLOG.content
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BLOG.id
     *
     * @return the value of BLOG.id
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BLOG.id
     *
     * @param id the value for BLOG.id
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BLOG.create_date
     *
     * @return the value of BLOG.create_date
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BLOG.create_date
     *
     * @param createDate the value for BLOG.create_date
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BLOG.modify_date
     *
     * @return the value of BLOG.modify_date
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BLOG.modify_date
     *
     * @param modifyDate the value for BLOG.modify_date
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BLOG.title
     *
     * @return the value of BLOG.title
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BLOG.title
     *
     * @param title the value for BLOG.title
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BLOG.content
     *
     * @return the value of BLOG.content
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BLOG.content
     *
     * @param content the value for BLOG.content
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
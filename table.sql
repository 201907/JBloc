-- 创建数据库
CREATE DATABASE JBloc DEFAULT charset utf8;
-- 切换数据库
use JBloc;
-- 用户表
CREATE TABLE USER (
  --   用户名
  id          INT PRIMARY KEY auto_increment NOT NULL,
  --   登录名
  login_name  VARCHAR(20) NOT NULL UNIQUE,
  --   昵称
  user_name   VARCHAR(20) NOT NULL UNIQUE,
  --   密码
  password    VARCHAR(50) NOT NULL,
  --   邮箱
  email       VARCHAR(50),
  --   创建时间
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  --   用户积分
  point       INT       DEFAULT 0 NOT NULL,
  --   用户头像
  icon        MediumBlob,
  --   用户等级
  level       INT(1)    DEFAULT 1 NOT NULL
)ENGINE = innodb DEFAULT charset = utf8;
-- shadowsocks
CREATE TABLE SHADOWINFO (
  --   id
  id             INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  --   ip地址
  ip             VARCHAR(30)                    NOT NULL,
  --   端口
  port           INT(6)                         NOT NULL,
  --   密码
  password       VARCHAR(30)                    NOT NULL,
  --   加密方式
  encrypt_method VARCHAR(20)                    NOT NULL
)ENGINE = innodb DEFAULT charset = utf8;
-- 博客表
CREATE TABLE BLOG (
  --   id
  id          INT AUTO_INCREMENT PRIMARY KEY       NOT NULL,
  --   创建时间
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  --   修改时间
  modify_date TIMESTAMP                            NOT NULL,
  --   标题
  title       VARCHAR(50)                          NOT NULL,
  --   内容
  content     LONGTEXT,
  --   用户id外键
  use_id     INT                                  NOT NULL,
  FOREIGN KEY (use_id) REFERENCES USER (id)
)ENGINE = innodb DEFAULT charset = utf8;
-- 代码表
CREATE TABLE CODE (
  --   id
  id      INT AUTO_INCREMENT PRIMARY KEY                     NOT NULL,
  --   代码
  code    LONGTEXT                                           NOT NULL,
  --   博客外键
  blog_id INT                                                NOT NULL,
  FOREIGN KEY (blog_id) REFERENCES BLOG (id)
)ENGINE = innodb DEFAULT charset = utf8;
-- 自动更新修改时间触发器
delimiter $
CREATE TRIGGER UPDATE_MODIFY_DATE
  BEFORE
  UPDATE
  ON BLOG
  FOR EACH ROW
BEGIN
SET new.modify_date = now();
END$
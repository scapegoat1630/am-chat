package com.am.chat.model.vo;

import java.util.Date;

/**
 * Created by zhangpeng12 on 2017/1/16.
 */
public class UserRegisterRequest {

    /**
     *  用户名,所属表字段为name
     */
    private String name;

    /**
     *  密码,所属表字段为am_user.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     *  年龄,所属表字段为age
     */
    private Integer age;

    /**
     *  生日,所属表字段为birthday
     */
    private Date birthday;

    /**
     *  男or女,所属表字段为sex
     */
    private Integer sex;

    /**
     *  昵称,所属表字段为nickname
     */
    private String nickname;


    private String intro;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserRegisterRequest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", nickname='" + nickname + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }
}

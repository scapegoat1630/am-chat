package com.am.chat.model.vo;

import java.util.Date;

/**
 * Created by zhangpeng12 on 2016/12/22.
 */
public class UserVo {
    /**
     *  id,所属表字段为am_user.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *  用户名,所属表字段为am_user.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     *  年龄,所属表字段为am_user.age
     *
     * @mbggenerated
     */
    private Integer age;

    /**
     *  生日,所属表字段为am_user.birthday
     *
     * @mbggenerated
     */
    private Date birthday;

    /**
     *  男or女,所属表字段为am_user.sex
     *
     * @mbggenerated
     */
    private Integer sex;

    /**
     *  昵称,所属表字段为am_user.nickname
     *
     * @mbggenerated
     */
    private String nickname;

    /**
     *  头像,所属表字段为am_user.headimage
     *
     * @mbggenerated
     */
    private String headimage;

    private String intro;

    /**
     *  用户状态,所属表字段为am_user.state
     *
     * @mbggenerated
     */
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", nickname='" + nickname + '\'' +
                ", headimage='" + headimage + '\'' +
                ", intro='" + intro + '\'' +
                ", state=" + state +
                '}';
    }
}

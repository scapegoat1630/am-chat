package com.am.chat.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
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
     *  密码,所属表字段为am_user.password
     *
     * @mbggenerated
     */
    private String password;

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
     *  电话,所属表字段为am_user.phonenumber
     *
     * @mbggenerated
     */
    private Integer phonenumber;

    /**
     *  昵称,所属表字段为am_user.nickname
     *
     * @mbggenerated
     */
    private String nickname;

    /**
     *  地址,所属表字段为am_user.address
     *
     * @mbggenerated
     */
    private String address;

    /**
     *  头像,所属表字段为am_user.headimage
     *
     * @mbggenerated
     */
    private String headimage;

    /**
     *  简介,所属表字段为am_user.intro
     *
     * @mbggenerated
     */
    private String intro;

    /**
     *  用户状态,所属表字段为am_user.state
     *
     * @mbggenerated
     */
    private Integer state;

    /**
     *  备注,所属表字段为am_user.comments
     *
     * @mbggenerated
     */
    private String comments;

    /**
     *  ,所属表字段为am_user.k1
     *
     * @mbggenerated
     */
    private String k1;

    /**
     *  ,所属表字段为am_user.k2
     *
     * @mbggenerated
     */
    private Integer k2;

    /**
     *  ,所属表字段为am_user.k3
     *
     * @mbggenerated
     */
    private Date k3;

    /**
     *  ,所属表字段为am_user.k4
     *
     * @mbggenerated
     */
    private Date k4;

    /**
     *  ,所属表字段为am_user.k5
     *
     * @mbggenerated
     */
    private String k5;

    /**
     *  ,所属表字段为am_user.k6
     *
     * @mbggenerated
     */
    private String k6;

    /**
     *  ,所属表字段为am_user.k8
     *
     * @mbggenerated
     */
    private String k8;

    /**
     *  ,所属表字段为am_user.k9
     *
     * @mbggenerated
     */
    private String k9;

    /**
     *  ,所属表字段为am_user.k7
     *
     * @mbggenerated
     */
    private String k7;

    private static final long serialVersionUID = 1L;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getK1() {
        return k1;
    }

    public void setK1(String k1) {
        this.k1 = k1;
    }

    public Integer getK2() {
        return k2;
    }

    public void setK2(Integer k2) {
        this.k2 = k2;
    }

    public Date getK3() {
        return k3;
    }

    public void setK3(Date k3) {
        this.k3 = k3;
    }

    public Date getK4() {
        return k4;
    }

    public void setK4(Date k4) {
        this.k4 = k4;
    }

    public String getK5() {
        return k5;
    }

    public void setK5(String k5) {
        this.k5 = k5;
    }

    public String getK6() {
        return k6;
    }

    public void setK6(String k6) {
        this.k6 = k6;
    }

    public String getK8() {
        return k8;
    }

    public void setK8(String k8) {
        this.k8 = k8;
    }

    public String getK9() {
        return k9;
    }

    public void setK9(String k9) {
        this.k9 = k9;
    }

    public String getK7() {
        return k7;
    }

    public void setK7(String k7) {
        this.k7 = k7;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getPhonenumber() == null ? other.getPhonenumber() == null : this.getPhonenumber().equals(other.getPhonenumber()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getHeadimage() == null ? other.getHeadimage() == null : this.getHeadimage().equals(other.getHeadimage()))
            && (this.getIntro() == null ? other.getIntro() == null : this.getIntro().equals(other.getIntro()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getComments() == null ? other.getComments() == null : this.getComments().equals(other.getComments()))
            && (this.getK1() == null ? other.getK1() == null : this.getK1().equals(other.getK1()))
            && (this.getK2() == null ? other.getK2() == null : this.getK2().equals(other.getK2()))
            && (this.getK3() == null ? other.getK3() == null : this.getK3().equals(other.getK3()))
            && (this.getK4() == null ? other.getK4() == null : this.getK4().equals(other.getK4()))
            && (this.getK5() == null ? other.getK5() == null : this.getK5().equals(other.getK5()))
            && (this.getK6() == null ? other.getK6() == null : this.getK6().equals(other.getK6()))
            && (this.getK8() == null ? other.getK8() == null : this.getK8().equals(other.getK8()))
            && (this.getK9() == null ? other.getK9() == null : this.getK9().equals(other.getK9()))
            && (this.getK7() == null ? other.getK7() == null : this.getK7().equals(other.getK7()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getPhonenumber() == null) ? 0 : getPhonenumber().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getHeadimage() == null) ? 0 : getHeadimage().hashCode());
        result = prime * result + ((getIntro() == null) ? 0 : getIntro().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getComments() == null) ? 0 : getComments().hashCode());
        result = prime * result + ((getK1() == null) ? 0 : getK1().hashCode());
        result = prime * result + ((getK2() == null) ? 0 : getK2().hashCode());
        result = prime * result + ((getK3() == null) ? 0 : getK3().hashCode());
        result = prime * result + ((getK4() == null) ? 0 : getK4().hashCode());
        result = prime * result + ((getK5() == null) ? 0 : getK5().hashCode());
        result = prime * result + ((getK6() == null) ? 0 : getK6().hashCode());
        result = prime * result + ((getK8() == null) ? 0 : getK8().hashCode());
        result = prime * result + ((getK9() == null) ? 0 : getK9().hashCode());
        result = prime * result + ((getK7() == null) ? 0 : getK7().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", age=").append(age);
        sb.append(", birthday=").append(birthday);
        sb.append(", sex=").append(sex);
        sb.append(", phonenumber=").append(phonenumber);
        sb.append(", nickname=").append(nickname);
        sb.append(", address=").append(address);
        sb.append(", headimage=").append(headimage);
        sb.append(", intro=").append(intro);
        sb.append(", state=").append(state);
        sb.append(", comments=").append(comments);
        sb.append(", k1=").append(k1);
        sb.append(", k2=").append(k2);
        sb.append(", k3=").append(k3);
        sb.append(", k4=").append(k4);
        sb.append(", k5=").append(k5);
        sb.append(", k6=").append(k6);
        sb.append(", k8=").append(k8);
        sb.append(", k9=").append(k9);
        sb.append(", k7=").append(k7);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.emo.pojo;

public class User {
    private int u_id;
    private String username;
    private String password;
    private String sex;
    private String phonenum;

    public User(int u_id, String username, String password, String sex, String phonenum) {
        this.u_id = u_id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.phonenum = phonenum;
    }

    public User() {
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", phonenum=" + phonenum +
                '}';
    }
}

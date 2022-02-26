package com.emo.pojo;

public class Euser {
    private int e_id;
    private String e_username;
    private String e_sex;
    private String e_num;
    private String e_head;
    private String vx_id;

    @Override
    public String toString() {
        return "Euser{" +
                "e_id=" + e_id +
                ", e_username='" + e_username + '\'' +
                ", e_sex='" + e_sex + '\'' +
                ", e_num='" + e_num + '\'' +
                ", e_head='" + e_head + '\'' +
                ", vx_id=" + vx_id +
                '}';
    }

    public String getVx_id() {
        return vx_id;
    }

    public void setVx_id(String vx_id) {
        this.vx_id = vx_id;
    }

    public Euser(String vx_id) {
        this.vx_id = vx_id;
    }

    public Euser(int e_id, String e_username, String e_sex, String e_num, String e_head) {
        this.e_id = e_id;
        this.e_username = e_username;
        this.e_sex = e_sex;
        this.e_num = e_num;
        this.e_head = e_head;
    }

    public Euser() {
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_username() {
        return e_username;
    }

    public void setE_username(String e_username) {
        this.e_username = e_username;
    }

    public String getE_sex() {
        return e_sex;
    }

    public void setE_sex(String e_sex) {
        this.e_sex = e_sex;
    }

    public String getE_num() {
        return e_num;
    }

    public void setE_num(String e_num) {
        this.e_num = e_num;
    }

    public String getE_head() {
        return e_head;
    }

    public void setE_head(String e_head) {
        this.e_head = e_head;
    }

}

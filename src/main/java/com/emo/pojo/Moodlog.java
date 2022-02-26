package com.emo.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Moodlog {
    private int id;
    private String title;
    private String concent;
    private  String addtime;

    public Moodlog(int id, String title, String concent, String addtime) {
        this.id = id;
        this.title = title;
        this.concent = concent;
        this.addtime = addtime;

    }


    public Moodlog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getConcent() {
        return concent;
    }

    public void setConcent(String concent) {
        this.concent = concent;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    @Override
    public String toString() {
        return "Moodlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", concent='" + concent + '\'' +
                ", addtime='" + addtime + '\'' +
                '}';
    }
}

package com.emo.pojo;

public class Emotion {
    private int id;
    private String title;
    private String concent;

    public Emotion(int id, String title, String concent) {
        this.id = id;
        this.title = title;
        this.concent = concent;
    }

    public Emotion() {
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

    @Override
    public String toString() {
        return "emotion{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", concent='" + concent + '\'' +
                '}';
    }
}

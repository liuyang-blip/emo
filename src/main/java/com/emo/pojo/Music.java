package com.emo.pojo;

public class Music {
    private int id;
    private String mold;
    private String music;

    public Music() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMold() {
        return mold;
    }

    public void setMold(String mold) {
        this.mold = mold;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", mold='" + mold + '\'' +
                ", music='" + music + '\'' +
                '}';
    }

    public Music(int id, String mold, String music) {
        this.id = id;
        this.mold = mold;
        this.music = music;

    }
}

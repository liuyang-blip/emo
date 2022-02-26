package com.emo.pojo;

public class Book {
    private int id;
    private String bookname;
    private String bookphoto;
    private String filepath;
    private String creattime;

    public Book(int id, String bookname, String bookphoto, String filepath, String creattime) {
        this.id = id;
        this.bookname = bookname;
        this.bookphoto = bookphoto;
        this.filepath = filepath;
        this.creattime = creattime;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookphoto() {
        return bookphoto;
    }

    public void setBookphoto(String bookphoto) {
        this.bookphoto = bookphoto;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", bookphoto='" + bookphoto + '\'' +
                ", filepath='" + filepath + '\'' +
                ", creattime='" + creattime + '\'' +
                '}';
    }
}

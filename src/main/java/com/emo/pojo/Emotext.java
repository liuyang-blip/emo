package com.emo.pojo;

public class Emotext {
    private int id;
    private String content;
    private String answer;
    private String rightanswer;
    private String erroranswer;
    private String score;

    public Emotext(int id, String content, String answer, String rightanswer, String erroranswer, String score) {
        this.id = id;
        this.content = content;
        this.answer = answer;
        this.rightanswer = rightanswer;
        this.erroranswer = erroranswer;
        this.score = score;
    }

    public Emotext() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getRightanswer() {
        return rightanswer;
    }

    public void setRightanswer(String rightanswer) {
        this.rightanswer = rightanswer;
    }

    public String getErroranswer() {
        return erroranswer;
    }

    public void setErroranswer(String erroranswer) {
        this.erroranswer = erroranswer;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Emotext{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", answer='" + answer + '\'' +
                ", rightanswer='" + rightanswer + '\'' +
                ", erroranswer='" + erroranswer + '\'' +
                ", score=" + score +
                '}';
    }

}

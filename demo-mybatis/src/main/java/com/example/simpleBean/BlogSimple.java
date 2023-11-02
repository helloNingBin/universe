package com.example.simpleBean;

import java.util.Date;

public class BlogSimple {

    private String author;
    private Date selectTime;
    private String content;

    public BlogSimple(String author, Date selectTime) {
        this.author = author;
        this.selectTime = selectTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getSelectTime() {
        return selectTime;
    }

    public void setSelectTime(Date selectTime) {
        this.selectTime = selectTime;
    }

    @Override
    public String toString() {
        return "BlogSimple{" +
                "author='" + author + '\'' +
                ", selectTime=" + selectTime +
                ", content='" + content + '\'' +
                '}';
    }
}

package com.example.mapper;

import java.util.Date;
/**
 *
 CREATE TABLE  `blog` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自动增长',
 `date` datetime NOT NULL COMMENT ' ',
 `author_id` bigint(20) NOT NULL COMMENT ' ',
 `title` varchar(32)  NULL COMMENT ' ',
 `content` varchar(32)  NULL COMMENT ' ',
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 *
 */
public class Blog {
    private long id;
    private Date date;
    private long authorId;//author_id
    private String title;//title
    private String content;
    public Blog(long id, Date date, long authorId, String title, String content) {
        this.id = id;
        this.date = date;
        this.authorId = authorId;
        this.title = title;
        this.content = content;
    }

    public Blog(Date date, long authorId, String title, String content) {
        this.date = date;
        this.authorId = authorId;
        this.title = title;
        this.content = content;
    }

    public Blog() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", date=" + date +
                ", authorId='" + authorId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

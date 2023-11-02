package com.example.simpleBean;

import java.util.Date;

/**
 *        P.id as post_id,
 *        P.blog_id as post_blog_id,
 *        P.author_id as post_author_id,
 *        P.created_on as post_created_on,
 *        P.section as post_section,
 *        P.subject as post_subject,
 *        P.draft as draft,
 *        P.body as post_body,
 *
 CREATE TABLE  `post` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自动增长',
 `blog_id` bigint(20) NOT NULL COMMENT ' ',
 `author_id` bigint(20) NOT NULL COMMENT ' ',
 `created_on` datetime NOT NULL COMMENT ' ',
 `section` varchar(32)  NULL COMMENT ' ',
 `subject` varchar(32)  NULL COMMENT ' ',
 `draft` varchar(32)  NULL COMMENT ' ',
 `body` varchar(32)  NULL COMMENT ' ',
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 */
public class Post {
    private long id;
    private long blogId;//blog_id
    private long authorId;//author_id
    private Date createdOn;//created_on
    private String subject;//subject
    private String draft;//draft
    private String body;//body

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", blogId=" + blogId +
                ", authorId=" + authorId +
                ", createdOn=" + createdOn +
                ", subject='" + subject + '\'' +
                ", draft='" + draft + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBlogId() {
        return blogId;
    }

    public void setBlogId(long blogId) {
        this.blogId = blogId;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDraft() {
        return draft;
    }

    public void setDraft(String draft) {
        this.draft = draft;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}

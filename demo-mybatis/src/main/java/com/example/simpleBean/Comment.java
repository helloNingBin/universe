package com.example.simpleBean;

/**
 *    C.id as comment_id,
 *        C.post_id as comment_post_id,
 *        C.name as comment_name,
 *        C.comment as comment_text,
 CREATE TABLE  `comment` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自动增长',
 `post_id` bigint(20) NOT NULL COMMENT ' ',
 `name` varchar(32)  NULL COMMENT ' ',
 `comment` varchar(32)  NULL COMMENT ' ',
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 */
public class Comment {
    private long id;//id

    private long postId;//post_id

    private String name;//name
    private String comment;//comment

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", postId=" + postId +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

package com.example.simpleBean;

/**
 * Post和Tag的中间表
 *
 CREATE TABLE  `comment` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自动增长',
 `post_id` bigint(20) NOT NULL COMMENT ' ',
 `tag_id` bigint(20) NOT NULL COMMENT ' ',
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 */
public class PostTag {
    private long id;
    private long postId;
    private long tagId;

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

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "PostTag{" +
                "id=" + id +
                ", postId=" + postId +
                ", tagId=" + tagId +
                '}';
    }
}

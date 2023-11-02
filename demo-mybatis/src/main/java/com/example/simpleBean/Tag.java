package com.example.simpleBean;

/**
 *     T.id as tag_id,
 *        T.name as tag_name

 CREATE TABLE  `tag` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自动增长',
 `name` varchar(32)  NULL COMMENT ' ',
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 */
public class Tag {
    private long id;
    private String name;
}

package com.example.simpleBean;

/**
 *
 CREATE TABLE  `author` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自动增长',
 `username` varchar(32) NOT NULL COMMENT ' ',
 `password` varchar(32) NOT NULL COMMENT ' ',
 `email` varchar(32)  NULL COMMENT ' ',
 `bio` varchar(32)  NULL COMMENT ' ',
 `favourite_section` varchar(32)  NULL COMMENT ' ',
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 insert into author(id,username,password,email,bio,favourite_section)values
 (1,'aaa','aaa','aaa@mail','bio_aa','fava_aa'),
 (2,'bbbb','bbbb','bbb@mail','bio_bb','fava_bb'),
 (3,'cccc','cccc','cccc@mail','bio_cccc','fava_ccc')
 *
 */
public class Author {
    private long id;
    private String userName;
    private String password;
    private String email;
    private String bio;
    private String favouriteSection;//favourite_section

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getFavouriteSection() {
        return favouriteSection;
    }

    public void setFavouriteSection(String favouriteSection) {
        this.favouriteSection = favouriteSection;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", bio='" + bio + '\'' +
                ", favouriteSection='" + favouriteSection + '\'' +
                '}';
    }
}

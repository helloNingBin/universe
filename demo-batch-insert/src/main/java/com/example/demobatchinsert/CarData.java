package com.example.demobatchinsert;

import java.util.Date;

/**
 * d

 drop table car_data;
 CREATE TABLE car_data (
 id INT AUTO_INCREMENT PRIMARY KEY,
 uuid VARCHAR(128),
 data VARCHAR(512),
 maper VARCHAR(512),
 create_date DATETIME
 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 */
public class CarData {
    private Long id;
    private String uuid;
    private String data;
    private String maper;
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMaper() {
        return maper;
    }

    public void setMaper(String maper) {
        this.maper = maper;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
// 省略构造方法、getter和setter
}

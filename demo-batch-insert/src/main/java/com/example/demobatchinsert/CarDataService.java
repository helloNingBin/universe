package com.example.demobatchinsert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class CarDataService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertCarDataBatch() {
        int batchSize = 1000000;

        jdbcTemplate.batchUpdate(
                "INSERT INTO car_data (uuid, data, maper, create_date) VALUES (?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        String uuid = UUID.randomUUID().toString();
                        String data = "插入数据的时间：" + new SimpleDateFormat("HH-mm-ss-SSS").format(new Date());
                        String maper = String.valueOf(uuid.hashCode());
                        Date createDate = new Date();

                        ps.setString(1, uuid);
                        ps.setString(2, data);
                        ps.setString(3, maper);
                        ps.setTimestamp(4, new java.sql.Timestamp(createDate.getTime()));
                    }

                    @Override
                    public int getBatchSize() {
                        return batchSize;
                    }
                }
        );
    }
}

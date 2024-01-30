package com.example.demobatchinsert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CarDataController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private CarDataService carDataService;

    @GetMapping("/insertCarData")
    public String insertCarData(int batchSize) {
        long l = System.currentTimeMillis();

        List<Object[]> batchArgs = new ArrayList<>(batchSize);

        for (int i = 0; i < batchSize; i++) {
            String uuid = UUID.randomUUID().toString();
            String data = "插入数据的时间：" + new SimpleDateFormat("HH-mm-ss-SSS").format(new Date());
            String maper = String.valueOf(uuid.hashCode());
            Date createDate = new Date();

            Object[] values = {uuid, data, maper, createDate};
            batchArgs.add(values);
        }

        String sql = "INSERT INTO car_data (uuid, data, maper, create_date) VALUES (?, ?, ?, ?)";
        jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println("===>" + (System.currentTimeMillis() - l));
        return "Data inserted successfully!" + (System.currentTimeMillis() - l);
    }

    @GetMapping("/insertCarData2")
    public String insertCarData2(int batchSize) {
        long l = System.currentTimeMillis();
        carDataService.insertCarDataBatch();
        System.out.println("===>" + (System.currentTimeMillis() - l));
        return "Data inserted successfully!" + (System.currentTimeMillis() - l);
    }
}

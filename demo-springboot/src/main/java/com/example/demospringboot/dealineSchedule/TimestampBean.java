package com.example.demospringboot.dealineSchedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimestampBean {
    private long timestamp;
    private String scheduleNo;
}

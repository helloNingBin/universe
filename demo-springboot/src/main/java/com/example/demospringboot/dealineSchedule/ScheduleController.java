package com.example.demospringboot.dealineSchedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.nio.channels.Pipe;

@RestController
@Slf4j
public class ScheduleController {
    @Autowired
    private ScheduleRunner scheduleRunner;
    @GetMapping("/schedule/add")
    public String add(int seconds){
        scheduleRunner.add(new TimestampBean(System.currentTimeMillis() + (seconds*1000),"NO:" + seconds));
        return "ok";
    }
//    @PostConstruct
    private void add(){
        long s = System.currentTimeMillis();
        for(int i = 0;i<100000;i++){
            if(i%2000==0){
                log.info("第{}个",i);
            }
            int seconds = 5000;
            scheduleRunner.add(new TimestampBean(System.currentTimeMillis() + (seconds*1000),"!NO"));
        }
        log.info("加入一百万个元素消费的时间:{}",(System.currentTimeMillis() -s));

        for(int i = 0;i<10;i++){
            int seconds = 10;
            scheduleRunner.add(new TimestampBean(System.currentTimeMillis() + (seconds*1000),"NO:" + seconds));
        }
        for(int i = 0;i<10;i++){
            int seconds = 15;
            scheduleRunner.add(new TimestampBean(System.currentTimeMillis() + (seconds*1000),"NO:" + seconds));
        }
        for(int i = 0;i<10;i++){
            int seconds = 25;
            scheduleRunner.add(new TimestampBean(System.currentTimeMillis() + (seconds*1000),"NO:" + seconds));
        }
    }
}

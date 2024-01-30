package com.example.demospringboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@RestController
@Slf4j
public class ScheduledController {
    private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final static Map<String,Long> doorMap = new HashMap<>();

    public String send(String deviceNo){
        long openTime = doorMap.get(deviceNo) == null ? 0l : doorMap.get(deviceNo);
        long currentTime = System.currentTimeMillis();
        doorMap.put(deviceNo, currentTime);
        if(currentTime - openTime < 2100){

        }

        log.info("deviceNo:{}",deviceNo);
        return "ok";
    }

}

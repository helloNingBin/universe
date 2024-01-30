package com.example.demospringboot.dealineSchedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class ScheduleRunner implements CommandLineRunner {
    private final static List<TimestampBean> timestampList = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {
        while (true){
            log.info("开始循环。。。。。。。。");
            try {
                List<TimestampBean> timeoutList = getTimeoutList();
                timeoutList.stream().forEach(bean->{
                    log.info("当前时间：{},预计执行时间:{}",System.currentTimeMillis(),bean.getTimestamp());
                });
            }catch(InterruptedException e){
                log.info("have early bean insert.");
            }

        }
    }
    public List<TimestampBean> getTimeoutList() throws InterruptedException {
        log.info("getTimeoutList.........");
        List<TimestampBean> list = new ArrayList<>();
        synchronized (timestampList){
            Iterator<TimestampBean> iterator = timestampList.iterator();
            while (iterator.hasNext()){
                TimestampBean bean = iterator.next();
                if(bean.getTimestamp() > System.currentTimeMillis()){
                    break;
                }
                list.add(bean);
                iterator.remove();
            }
            if(list.isEmpty()){
                long blockTime = timestampList.isEmpty() ? Integer.MAX_VALUE :
                        timestampList.get(0).getTimestamp() - System.currentTimeMillis();
                log.info("没有可执行的元素，开始休眠：{}",blockTime);
                timestampList.wait(blockTime);
                log.info("休眠时间已经到了。。。。。。。");
                return getTimeoutList();
            }
        }
        return list;
    }
    public void add(TimestampBean bean){
        long s = System.currentTimeMillis();
        synchronized (timestampList){
            timestampList.add(bean);
            Collections.sort(timestampList, Comparator.comparingLong(TimestampBean::getTimestamp));
//            log.info("加入一个元素：{},list:{}",bean,timestampList);
            if(timestampList.get(0) == bean || timestampList.get(0).getTimestamp() > bean.getTimestamp()){
//                log.info("notify .........");
                timestampList.notify();
            }
        }
        if(!bean.getScheduleNo().equals("!NO")){
            log.info("加入一个元素消费的时间:{}",(System.currentTimeMillis() -s));
        }
    }
}

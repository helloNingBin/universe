package com.example.demospringboot.dealineSchedule;

import java.util.*;
import java.util.stream.Collectors;

public class ScheduleMain {
    static List<TimestampBean> timestampList = new ArrayList<>();
static {
    long s = System.currentTimeMillis();
    Random r = new Random();
    for(int i = 0;i<100000;i++){
        timestampList.add(new TimestampBean(System.currentTimeMillis() +i + r.nextInt(1000000), "no:"+i));
    }
    System.out.println("insert time:" + (System.currentTimeMillis() - s));
    s = System.currentTimeMillis();
    Collections.sort(timestampList, Comparator.comparingLong(TimestampBean::getTimestamp));
    System.out.println("sort time:" + (System.currentTimeMillis() - s));
}
    public static void main(String[] args) {
        Random r = new Random();
        for(int i = 0;i<1000;i++){
            long s = System.currentTimeMillis();
            timestampList.add(new TimestampBean(System.currentTimeMillis()-6767 +i - r.nextInt(1000000), "no:"+i));
            Collections.sort(timestampList, Comparator.comparingLong(TimestampBean::getTimestamp));
            System.out.println("sort time:" + (System.currentTimeMillis() - s));
        }
    }
    public void add(TimestampBean bean){
        synchronized (timestampList){
            timestampList.add(bean);
            Collections.sort(timestampList, Comparator.comparingLong(TimestampBean::getTimestamp));
        }
    }
    public void doAction(){
        List<TimestampBean> list = new ArrayList<>();
        Iterator<TimestampBean> iterator = timestampList.iterator();
        while (iterator.hasNext()){
            TimestampBean bean = iterator.next();
            if(bean.getTimestamp() > System.currentTimeMillis()){
                break;
            }
            list.add(bean);
            iterator.remove();
        }
    }
}

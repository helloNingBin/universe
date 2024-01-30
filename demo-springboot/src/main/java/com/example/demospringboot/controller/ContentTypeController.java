package com.example.demospringboot.controller;

import com.alibaba.fastjson.JSON;
import com.example.demospringboot.Person;
import com.ning.io.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class ContentTypeController {
    /**
     * 只接收content-type为：application/x-www-form-urlencoded和params（即?name=aaa&age=44)
     * 不接收content-type为：josn的
     */
    @PostMapping("/postEntity")
    public String postEntity(Person person){
        return ""+person;
    }

    /**
     *只能接收body的json数据，不能接收params
     * 同时，body的数据为空时会出现400，但可以是一个空josn{}
     */
    @PostMapping("/postBody")
    public String postBody(@RequestBody Person person){
        return "ok"+person;
    }
    /*
    localhost:8080/postBodyAndEntity?name=dsfd
    okPerson(name=kk, age=0)===Person(name=dsfd, age=0)
    person接收body中的数据，p接收param中的数据
     */
    @PostMapping("/postBodyAndEntity")
    public String postBodyAndEntity(@RequestBody Person person,Person p){
        return "ok"+person+"==="+p;
    }
    /*
  localhost:8080/postBodyAndParam?p=dsfd
okPerson(name=kk, age=0),dsfd
   person接收body中的数据，p接收param中的数据
    */
    @PostMapping("/postBodyAndParam")
    public String postBodyAndParam(@RequestBody Person person,String p){
        return "ok"+person+","+p;
    }
    /*
    这样可以成功：不要{}对象，直接数组
    [{"age":11,"name":"aa"},{"age":22,"name":"bb"}]
     */
    @PostMapping("/postList")
    public String postList(@RequestBody List<Person> list){
        return "ok"+list;
    }
    /*
    这样的POJO，List接收不了，除非是String，基本类型。
    如果有多个参数，只能是重新做一个POJO了
     */
    @PostMapping("/postListWithoutRequestBody")
    public String postListWithoutRequestBody(@RequestParam List<Person> list){
        return "ok"+list;
    }
    @PostMapping("/postListString")
    public String postListString(@RequestBody List<String> list){
        return "ok"+list;
    }
    /*
    2020-11-11:失败
    2020/11/11：成功
     */
    @PostMapping("/postDate")
    public String postDate(Date date){
        return "ok"+date;
    }
    /*
    {"age":11,"name":"aa","date":""}报错
     */
    @PostMapping("/postEntityWithDate")
    public String postEntityWithDate(Person person){
        return "ok"+person;
    }
    /*
    允许date为空
    {"age":11,"name":"aa","date":""}
    {"age":11,"name":"aa","date":"2022-11-11"}：success,but fail for 2022/11/11
     */
    @PostMapping("/postEntityWithDate2")
    public String postEntityWithDate2(@RequestBody Person person){
        return "ok"+person;
    }
    /*
      只能获取body中的数据，不能获取params的数据（即?name=aaa&age=44)
     */
    @PostMapping("/getPostContent")
    public String getPostContent(HttpServletRequest request) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String eventJson = IOUtils.read(reader);
        log.info(eventJson+",,,");
        return eventJson;
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        String s = JSON.toJSONString(list);
        System.out.println(s);
    }
}

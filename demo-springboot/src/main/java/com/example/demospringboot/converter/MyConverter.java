package com.example.demospringboot.converter;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class MyConverter implements Converter<String, Date> {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @SneakyThrows
    @Override
    public Date convert(String source) {
        log.info("convert {}",source);
        if(StringUtils.hasLength(source)){
            return sdf.parse(source);
        }
        return null;
    }
}

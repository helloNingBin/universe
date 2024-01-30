package com.example.demospringboot.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.HttpMessageConverter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonHttpMessageConverter implements HttpMessageConverter<Object> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return true;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return true;
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return Arrays.asList(MediaType.APPLICATION_JSON);
    }

    @Override
    public Object read(Class<?> clazz, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        try {
            return objectMapper.readValue(inputMessage.getBody(), clazz);
        } catch (IOException e) {
            throw new HttpMessageNotReadableException("Failed to read JSON", e);
        }
    }

    @Override
    public void write(Object o, MediaType contentType, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        try {
            objectMapper.writeValue(outputMessage.getBody(), o);
        } catch (IOException e) {
            throw new HttpMessageNotWritableException("Failed to write JSON", e);
        }
    }
}

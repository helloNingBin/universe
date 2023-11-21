package com.example.demospringboot.controller;

import com.ning.orc.LicensePlate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
public class ImageController {

    @PostMapping("/upload")
    public String handleImageUpload(@RequestBody ImageRequest imageRequest) throws UnsupportedEncodingException {
        String base64Data = imageRequest.getBase64Data();
        // 处理接收到的 Base64 数据，可以保存到文件或进行其他操作
        System.out.println("Received Base64 data: " + base64Data);
        base64Data = URLEncoder.encode(base64Data, "UTF-8");
        // 返回响应，可以根据需要返回 JSON 数据
        return LicensePlate.licensePlate(base64Data);
    }

    static class ImageRequest {
        private String base64Data;

        public String getBase64Data() {
            return base64Data;
        }

        public void setBase64Data(String base64Data) {
            this.base64Data = base64Data;
        }
    }
}

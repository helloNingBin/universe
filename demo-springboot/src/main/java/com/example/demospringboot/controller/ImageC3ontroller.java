package com.example.demospringboot.controller;

import com.benjaminwan.ocrlibrary.OcrResult;
import com.ning.file.ImageUtil;
import com.ning.orc.Base64Util;
import com.ning.orc.LicensePlate;
import com.ning.orc.VinCode;
import io.github.mymonstercat.Model;
import io.github.mymonstercat.ocr.InferenceEngine;
import io.github.mymonstercat.ocr.config.ParamConfig;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

@RestController
public class ImageC3ontroller {

    @PostMapping("/uploadImage3")
    public ResponseEntity<String> uploadImage(String base64Data)  {
        try {
            System.out.println(base64Data);

            // 将字节数组写入文件
            File imageFile = ImageUtil.convertBase64StrToImage(base64Data,"aaa.png");
            System.out.println(imageFile.exists() + "====>" + imageFile.getAbsolutePath() );
            ParamConfig paramConfig = ParamConfig.getDefaultConfig();
            paramConfig.setDoAngle(true);
            paramConfig.setMostAngle(true);
            InferenceEngine engine = InferenceEngine.getInstance(Model.ONNX_PPOCR_V3);
            // 开始识别E:/work/universe/demo-springboot/target/classes/images/test.png
//        OcrResult ocrResult = engine.runOcr(getResourcePath("images/test.png"), paramConfig);
            OcrResult ocrResult = engine.runOcr(imageFile.getPath(), paramConfig);
            String result = ocrResult.getStrRes().toString();
System.out.println(result + "=======>" + LicensePlate.findLicensePlate(result) + "==>" + VinCode.findVinCode(result));
            return new ResponseEntity<>("Image saved successfully: " + imageFile.getAbsolutePath(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to save image.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private File saveImage(byte[] content, String filenamePrefix) throws IOException {
        String fileType = determineFileType(content);
        File imageFile = File.createTempFile(filenamePrefix, "." + fileType);
        FileUtils.writeByteArrayToFile(imageFile, content);
        return imageFile;
    }

    private String determineFileType(byte[] content) {
        // 判断文件类型（这里简单演示，实际应该使用更复杂的逻辑）
        // 常见图片格式的文件头信息：https://en.wikipedia.org/wiki/List_of_file_signatures
        if (startsWith(content, "FFD8FF")) {
            return "jpg";
        } else if (startsWith(content, "89504E47")) {
            return "png";
        } else if (startsWith(content, "47494638")) {
            return "gif";
        } else {
            return "unknown";
        }
    }

    private boolean startsWith(byte[] content, String prefix) {
        String contentHex = bytesToHex(content, prefix.length());
        return contentHex.toUpperCase().startsWith(prefix);
    }

    private String bytesToHex(byte[] bytes, int length) {
        StringBuilder hexStringBuilder = new StringBuilder(length * 2);
        for (int i = 0; i < length; i++) {
            hexStringBuilder.append(String.format("%02X", bytes[i]));
        }
        return hexStringBuilder.toString();
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

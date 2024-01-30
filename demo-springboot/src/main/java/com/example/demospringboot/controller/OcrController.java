package com.example.demospringboot.controller;

import com.benjaminwan.ocrlibrary.OcrResult;
import com.ning.orc.LicensePlate;
import com.ning.orc.VinCode;
import io.github.mymonstercat.Model;
import io.github.mymonstercat.ocr.InferenceEngine;
import io.github.mymonstercat.ocr.config.ParamConfig;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Monster
 */
@RestController
@RequestMapping("/ocr")
public class OcrController {
    public static void maine(String[] args) {
        OcrController o = new OcrController();
        System.out.println(o.ocr(""));
    }

    @GetMapping()
    public String ocr(String p) {
        ParamConfig paramConfig = ParamConfig.getDefaultConfig();
        paramConfig.setDoAngle(true);
        paramConfig.setMostAngle(true);
        InferenceEngine engine = InferenceEngine.getInstance(Model.ONNX_PPOCR_V3);
        // 开始识别E:/work/universe/demo-springboot/target/classes/images/test.png
//        OcrResult ocrResult = engine.runOcr(getResourcePath("images/test.png"), paramConfig);
        OcrResult ocrResult = engine.runOcr("E:/temp/"+p, paramConfig);
        String result = ocrResult.getStrRes().toString();
        System.out.println(result + "=======>" + findContent(result));
        return result + "=======>" + LicensePlate.findLicensePlate(result) + "==>" + VinCode.findVinCode(result);
    }

    @PostMapping
    public String ocr(@RequestParam("file") MultipartFile fileUpload) throws IOException {
        ParamConfig paramConfig = ParamConfig.getDefaultConfig();
        paramConfig.setDoAngle(true);
        paramConfig.setMostAngle(true);
        InferenceEngine engine = InferenceEngine.getInstance(Model.ONNX_PPOCR_V3);
        File file = new File(System.getProperty("java.io.tmpdir") + "ocrJava/test.png");
        fileUpload.transferTo(file);
        file.deleteOnExit();
        OcrResult ocrResult = engine.runOcr(file.getPath(),paramConfig);
        return ocrResult.getStrRes().toString();
    }


    @SneakyThrows
    private static String getResourcePath(String path) {
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(path).getPath());
        return Thread.currentThread().getContextClassLoader().getResource(path).getPath();
    }

    public static void main11(String[] args) {
        System.out.println(findContent("旧车置换户产过 京Q·58A77 camooecum"));
    }
    public static void main(String[] args) {
        System.out.println(findContent("LFV2A21K6A3092399 "));
    }
    public static String findContent(String text) {
//        String text = "旧车京Q58A76置换户产过 京Q58A77 camooecum";
        String licensePlateRegex = "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]([A-HJ-NP-Z0-9]{1}[A-HJ-NP-Z0-9]{1}[DF])|([A-HJ-NP-Z0-9]{2}[A-HJ-NP-Z0-9挂学警港澳]{1})|([A-HJ-NP-Z0-9]{2}[A-HJ-NP-Z0-9]{2}使))[\\s·•]?[A-HJ-NP-Z0-9]{1}[A-HJ-NP-Z0-9挂学警港澳]{1}[A-HJ-NP-Z0-9]{4}";
        String frameNumberRegex = "([A-HJ-NPR-Z0-9]{17})|([A-HJ-NPR-Z0-9]{8}\\d{6}[A-HJ-NPR-Z0-9]{2})";

        Pattern licensePlatePattern = Pattern.compile(licensePlateRegex);
        Pattern frameNumberPattern = Pattern.compile(frameNumberRegex);

        Matcher licensePlateMatcher = licensePlatePattern.matcher(text);
        Matcher frameNumberMatcher = frameNumberPattern.matcher(text);
       /* int i = licensePlateMatcher.groupCount();
        System.out.println("count:::::::::"+i);*/
        if (licensePlateMatcher.find()) {
            System.out.println("Found License Plate: " + licensePlateMatcher.group());
            return licensePlateMatcher.group();
        }

        if (frameNumberMatcher.find()) {
            System.out.println("Found Frame Number: " + frameNumberMatcher.group());
            return frameNumberMatcher.group();
        }
        return "not found";
    }
}

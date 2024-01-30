package com.ning.orc;



import java.net.URLEncoder;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 车牌识别
 */
public class LicensePlate {


    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String licensePlate() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/license_plate";
        try {
            // 本地文件路径
            String filePath = "E:\\temp\\车牌.png";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            return licensePlate(imgParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String licensePlate(String imgParam) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/license_plate";
        try {
          /*  // 本地文件路径
            String filePath = "E:\\temp\\车牌2.jpg";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");*/

            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.fb6103d74e57a3a7deeeb4ba447aef7d.2592000.1703125716.282335-43394277";

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static boolean isLicensePlate(String content) {
        String pattern = "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]{1}(([A-HJ-Z]{1}[A-HJ-NP-Z0-9]{5})|([A-HJ-Z]{1}(([DF]{1}[A-HJ-NP-Z0-9]{1}[0-9]{4})|([0-9]{5}[DF]{1})))|([A-HJ-Z]{1}[A-D0-9]{1}[0-9]{3}警)))|([0-9]{6}使)|((([沪粤川云桂鄂陕蒙藏黑辽渝]{1}A)|鲁B|闽D|蒙E|蒙H)[0-9]{4}领)|(WJ[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼·•]{1}[0-9]{4}[TDSHBXJ0-9]{1})|([VKHBSLJNGCE]{1}[A-DJ-PR-TVY]{1}[0-9]{5})";
        return Pattern.matches(pattern, content);
    }
    public static boolean isLicensePlate2(String licensePlace){
        // 车牌号正则表达式
        // 车牌号正则表达式
        String licensePlateRegex = "[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]([A-HJ-NP-Z0-9]{1}[A-HJ-NP-Z0-9]{1}[DF])|([A-HJ-NP-Z0-9]{2}[A-HJ-NP-Z0-9挂学警港澳]{1})|([A-HJ-NP-Z0-9]{2}[A-HJ-NP-Z0-9]{2}使)[A-HJ-NP-Z0-9]{1}[A-HJ-NP-Z0-9挂学警港澳]{1}[A-HJ-NP-Z0-9]{4}";

        Pattern licensePlatePattern = Pattern.compile(licensePlateRegex);
        Matcher licensePlateMatcher = licensePlatePattern.matcher(licensePlace);

        System.out.println(licensePlace + "==" + licensePlateMatcher.matches());
        return licensePlateMatcher.matches();
    }
    public static String findLicensePlate(String licensePlaces){
        // 删除非字母、数字、文字以外的字符
        String cleanedString = licensePlaces.replaceAll("[^A-Za-z0-9\\u4E00-\\u9FA5\\s]", "");
        System.out.println(cleanedString);
        // 以空格分隔字符串
        String[] parts = cleanedString.split("\\s");

        // 对每个分隔的部分进行车牌号或车架号的判断
        for (String part : parts) {
            if(isLicensePlate(part)){
                return part;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        LicensePlate.licensePlate();
    }







}

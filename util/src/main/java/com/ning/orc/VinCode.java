package com.ning.orc;



import java.net.URLEncoder;

/**
 * VIN码识别
 */
public class VinCode {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String vinCode() {
        // 请求url
        try {
            // 本地文件路径
            String filePath = "E:\\temp\\VIN1.jpg";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            System.out.println(imgParam);
            return vinCode(imgParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String vinCode(String imgParam) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/vin_code";
        try {
          /*  // 本地文件路径
            String filePath = "E:\\temp\\VIN1.jpg";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");*/

            System.out.println(imgParam);
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
    public static void main(String[] args) {
        VinCode.vinCode();
    }
}

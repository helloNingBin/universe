package com.ning.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogSearcher {

    public static void searchLog(String filePath, String keyword1, String keyword2) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean start = false;
            while ((line = reader.readLine()) != null) {

                if (line.contains(keyword1)) {//|| line.contains(keyword2)
                     System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//[ERROR] 2024-02-20 16:46:50,579 com.mobile.weixin.WeixinOpenCenterJumpServlet -
    public static void main(String[] args) {
        String filePath = "E:\\temp\\log\\mobile\\catalina.out";
        String keyword1 = "F240215231924382";
        String keyword2 = "[ERROR] 2024-02-20 16:46:50,788 com.mobile.weixin.WeixinAuthUtil - 微信用户个人信息------{\"openid\":\"oSaGm6L7HgKA";
        searchLog(filePath, keyword1, keyword2);
    }
}

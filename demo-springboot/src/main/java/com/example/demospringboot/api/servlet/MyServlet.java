package com.example.demospringboot.api.servlet;

import okhttp3.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "MyServlet", urlPatterns = "/myservlet")
public class MyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String appid = request.getParameter("appid");
        System.out.println("appid=====>" + appid);
        InputStream inputStream = request.getInputStream();
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        String requestBodyContent = result.toString("UTF-8");


        response.setContentType("text/plain");
        response.getWriter().println(requestBodyContent);
    }

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("appid","176844466126")
             /*   .addFormDataPart("nonce","kcLijfpbycpkwuuzzOYvOdLyrZzIjZho")
                .addFormDataPart("timestamp","1712586609")
                .addFormDataPart("sign","91c33643c1e60032ecd03473fc8822f0")*/
                .build();
        Request request = new Request.Builder()
                .url("https://xcx.jizwx.com/apipdf/car/token")
                .method("POST", body)
                .addHeader("authorization", "USERID MTc2ODQ0NDY2MTI2Olc5NzFhMjdWRmtiZzA5SDRDVDZvS1BZdHlySjM0TjMy")
                .addHeader("User-Agent", "Apifox/1.0.0 (https://apifox.com)")
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            // 获取响应体的内容
            String responseBody = response.body().string();
            System.out.println(responseBody);
        } else {
            System.out.println("请求失败，错误码：" + response.code());
        }
    }
}
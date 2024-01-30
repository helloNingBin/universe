package org.example;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class HelloElasticsearch {


    public static void main(String[] args) throws IOException {
        // 创建客户端对象
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost(ElasticSeacherCons.hostname, ElasticSeacherCons.port, ElasticSeacherCons.scheme
                )));
//		...
        System.out.println(client);

        // 关闭客户端连接
        client.close();
    }
}

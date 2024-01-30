package org.example;


import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;
/**
 * 创建索引
 */
public class CreateIndex {
//org.elasticsearch.action.admin.indices.create.CreateIndexRequest
//org.elasticsearch.client.indices
    public static void main(String[] args) throws IOException {
        // 创建客户端对象
        RestHighLevelClient client = ElasticSeacherCons.getClient();

        // 创建索引 - 请求对象
        CreateIndexRequest request = new CreateIndexRequest("user2");
        // 发送请求，获取响应
        CreateIndexResponse response = client.indices().create(request,
                RequestOptions.DEFAULT);
        boolean acknowledged = response.isAcknowledged();
        // 响应状态
        System.out.println("操作状态 = " + acknowledged);

        // 关闭客户端连接
        client.close();
    }

}

package org.example;

import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class ConnectElasticsearch{

    public static void connect(ElasticsearchTask task){
        // 创建客户端对象
        RestHighLevelClient client = ElasticSeacherCons.getClient();
        try {
            task.doSomething(client);
            // 关闭客户端连接
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

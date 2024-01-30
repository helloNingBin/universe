package org.example.select;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.RequestOptions;
import org.example.ConnectElasticsearch;

public class DeleteDoc {
    public static void main(String[] args) {
        ConnectElasticsearch.connect(client -> {
            //创建请求对象
            DeleteRequest request = new DeleteRequest().index("user").id("1001");
            //客户端发送请求，获取响应对象
            DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
            //打印信息
            System.out.println(response.toString());
            /**
             * DeleteResponse[index=user,type=_doc,id=1001,version=3,result=deleted,
             * shards=ShardInfo{total=2, successful=1, failures=[]}]
             */
        });
    }
}

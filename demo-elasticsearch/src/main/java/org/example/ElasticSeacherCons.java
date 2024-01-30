package org.example;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class ElasticSeacherCons {
    public static final String hostname = "139.159.196.163";
    public static final int port = 9200;
    public static  final String scheme = "http";
    public static RestHighLevelClient client;
    public static RestHighLevelClient getClient(){
        return new RestHighLevelClient(
                RestClient.builder(new HttpHost(ElasticSeacherCons.hostname, ElasticSeacherCons.port, ElasticSeacherCons.scheme
                )));
    }

}

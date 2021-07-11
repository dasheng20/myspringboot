package com.dongms.myspringboot.configure;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig {

    // spring = <bean id = "highLevelClient" class = "RestHighLevelClient">
    // 这里需要将对象注入spring
    @Bean
    public RestHighLevelClient highLevelClient() {
        // 如果是集群就配置多个, 如果不是集群就只配置一个
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")));
        return client;
    }

}
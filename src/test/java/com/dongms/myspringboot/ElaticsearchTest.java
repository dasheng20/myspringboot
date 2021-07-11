package com.dongms.myspringboot;

import com.alibaba.fastjson.JSON;
import com.dongms.myspringboot.entity.StudentEntity;
import com.dongms.myspringboot.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class ElaticsearchTest {

    @Autowired
    @Qualifier("highLevelClient")
    private RestHighLevelClient client;

    @Autowired
    UserService userService;

    @Test
    void createIndex() throws IOException {
        // 1、创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("yang_index");
        // 2、客户端执行创建请求, 请求完了获得响应, 判断是否存在
        CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println("createIndexResponse = " + createIndexResponse.index());
    }


    // 测试, 新增文档
    @Test
    void testAddDocument() throws IOException {
        int pageNum = 0;

        while (true){
            pageNum++;
            PageHelper.startPage(pageNum,10000);
//            List<StudentEntity> list = userService.findAllStu();
            PageInfo<StudentEntity> pageInfo = new PageInfo<>(userService.findAllStu());
            if (CollectionUtils.isEmpty(pageInfo.getList())){
                return;
            }
            for (StudentEntity studentEntity : pageInfo.getList()){
                // 创建请求
                IndexRequest request = new IndexRequest("cdsp");
                // PUT /索引/_doc/1 不默认id为1的话会产生一个随机的id
                request.id(studentEntity.getWid()+"");
                // 设置请求超时时间 request.timeout("1s");
                request.timeout(TimeValue.timeValueSeconds(1));
                // 将我们的数据放入请求 json 发出请求
                request.source(JSON.toJSONString(studentEntity), XContentType.JSON);
                // 客户端发出请求 获取响应结果
                IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
                System.out.println("indexResponse.toString() = " + indexResponse.toString());
                // 对应命令返回状态
                System.out.println("indexResponse.status() = " + indexResponse.status());
            }
        }






    }

    // 获取文档内容
    @Test
    void getDocument() throws IOException {
        GetRequest request = new GetRequest("yang_index", "1");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        // 获取指定字段 userName
        response.getField("wid");
        // 获取内容 或者可以封装成map或者其他内容
        System.out.println("response.getSourceAsString() = " + response.getSourceAsString());
        // 这里返回的内容跟是命令完全相同的
        System.out.println("response = " + response);
    }

}

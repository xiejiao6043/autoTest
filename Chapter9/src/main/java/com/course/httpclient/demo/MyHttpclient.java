package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpclient {
    @Test
    public void test1() throws IOException {
        String result;
        HttpGet get = new HttpGet("http://www.baidu.com");
        HttpClient client = new DefaultHttpClient();//需要执行get方法
        HttpResponse response = client.execute(get);//被访问
//        response.getEntity();//获取到响应中全体的内容，无法装换成字符串
        result = EntityUtils.toString(response.getEntity(),"utf-8");//将响应结果转换成字符串
        System.out.println(result);
    }
}

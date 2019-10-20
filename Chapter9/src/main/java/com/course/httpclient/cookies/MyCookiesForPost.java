package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    private CookieStore store;
    private String url;
    private ResourceBundle bundle;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        this.url = bundle.getString("test.url");

        String uri = bundle.getString("getCookies.uri");

    }


    @Test
    public void getCookies() throws IOException {
        String uri = bundle.getString("getCookies.uri");
        String testurl = this.url+uri;
        HttpGet get = new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        String result = EntityUtils.toString(response.getEntity(),"gbk");
        System.out.println(result);
        //
        this.store = client.getCookieStore();
        List<Cookie> cookies = store.getCookies();

        for (Cookie cookie:cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name="+name+" value= "+value);
        }
    }


    @Test(dependsOnMethods = {"getCookies"})
    public void testPostCookie() throws IOException {
        String uri = bundle.getString("test.post");
        String testUrl = this.url+uri;
        // 添加post方法
        HttpPost post = new HttpPost(testUrl);
        // client进行执行
        DefaultHttpClient client = new DefaultHttpClient();
        // 添加参数
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");
        // 设置请求头,设置header
        post.setHeader("Content-Type","application/json");
        // 设置cookie
        client.setCookieStore(this.store);
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        // 设置返回的response
        HttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity(),"gbk");
        System.out.println(result);
        // 将响应结果转换成json对象
        JSONObject resultJson = new JSONObject(result);
        // 查看返回响应
       String success= (String) resultJson.get("huhansan");
       String status = (String) resultJson.get("status");
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);
        //断言响应结果
    }

}

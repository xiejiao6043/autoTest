package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);//获取文件路径
        url = bundle.getString("test.url");

    }
    @Test
    public void testGetCookie() throws IOException {
        //获取配置变量
        String result;
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url +uri;
        //请求的步骤
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"gbk");
        System.out.println(result);
        // 获取Cookie
        this.store = client.getCookieStore();
        List<Cookie> cookieStores = store.getCookies();
        for (Cookie cookie:cookieStores) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name:"+name+" value:"+value);
        }
    }
    @Test(dependsOnMethods = {"testGetCookie"})
    public void testSetCookies() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url +uri;
        HttpGet get = new HttpGet(testUrl);

        DefaultHttpClient client = new DefaultHttpClient();
        //设置cookie
        client.setCookieStore(this.store);

        HttpResponse response = client.execute(get);
        int status = response.getStatusLine().getStatusCode();
        System.out.println("status="+status);
        if (status == 200) {
            String result = EntityUtils.toString(response.getEntity(),"gbk");
            System.out.println(result);
        }

    }

}

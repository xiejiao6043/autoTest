package com.course.server;

import hello.SampleController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我全部的get方法")
public class MyGetMethod {

    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到COOKies值",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        // HttpServletResponse: 装响应信息的类
        // HttpServletRequest: 装请求信息的类
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "你登录成功了";
    }
    /**
     * 这是一个需要携带cookie才能访问的请求
     * */
    @RequestMapping(value= "/get/with/cookies",method = RequestMethod.GET)
    @ApiOperation(value = "这是一个需要携带cookie才能访问的请求",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            return "你必须携带cookies信息来";
        }
        for (Cookie cookie:cookies) {
            if(cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "这是一个需要携带cookie才能访问的请求";
            }
        }
        return "你必须携带cookies信息来";
    }
    /**
     * 开发需要携带参数才能访问的get请求
     * 第一中实现形式：key=value&key=value
     * 模拟获取商品列表
     * */
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "第一中实现形式：key=value&key=value",httpMethod = "GET")
    public Map<String,Integer> getList(@RequestParam Integer start, @RequestParam Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("鞋",400);
        myList.put("裤子",120);
        myList.put("包包",200);
        return myList;
    }
    /**
     * 开发需要携带参数才能访问的get请求
     * 第二种实现形式：url：port/get/with/param/10/20
     * 模拟获取商品列表
     * */
    @RequestMapping(value = "/get/with/param/{start}/{end}")
    @ApiOperation(value = "第二种实现形式：url：port/get/with/param/10/20",httpMethod = "GET")
    public Map myGetList(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("鞋",400);
        myList.put("d裤子",120);
        myList.put("包包",200);
        return myList;
    }
}

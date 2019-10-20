package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这是我所有的post方法")
@RequestMapping(value = "/vi")
public class MyPostMethod {
    private static Cookie cookie;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "这是一个post的http请求",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "username",required = true)String userName,
                        @RequestParam(value = "password",required = true)String password){
        cookie = new Cookie("login","true");
        response.addCookie(cookie);
        if (userName.equals("zhangsan")&& password.equals("123456")) {
            return "恭喜你登录成功了";

        }
        return "用户名或者密码错误";

    }

    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                            @RequestBody User u){
        Cookie[] cookies = request.getCookies();
        User user;
        for (Cookie c:cookies
             ) {
            if(c.getName().equals("login")
                    && c.getValue().equals("true")
                    && u.getUserName().equals("zhangsan")
                    && u.getPassword().equals("123456")){
                user = new User();
                user.setName("lisi");
                user.setAge("18");
                user.setSex("nan");
                return user.toString();
            }


        }
        return "参数不合法";
    }





}

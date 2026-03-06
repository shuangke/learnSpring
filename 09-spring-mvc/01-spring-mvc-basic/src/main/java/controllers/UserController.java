package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody// 这个注解表示这个控制器的方法返回的字符串直接作为 HTTP 响应体返回，而不是视图名称
@RequestMapping("/users") // 这个注解表示这个控制器处理的请求路径前缀是 /user
public class UserController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello, Spring MVC!";
    }

    @RequestMapping("/hello2")
    public String hello2() {
        return "Hello, Spring MVC 2!";
    }

    @GetMapping("/login")
    public String login() {
        return "Login successful!";
    }

    // 这个注解表示这个方法处理 POST 请求，路径可以是 /user/register 或 /user/old/register
    @PostMapping( {"register","/old/register"})
    public String register() {
        return "Registration successful!";
    }
}

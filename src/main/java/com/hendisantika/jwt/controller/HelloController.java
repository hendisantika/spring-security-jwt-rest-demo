package com.hendisantika.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-security-jwt-rest-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/04/18
 * Time: 06.48
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello World!" + new Date();
    }

}

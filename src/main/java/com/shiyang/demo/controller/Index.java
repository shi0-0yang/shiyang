package com.shiyang.demo.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@Controller
public class Index{
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String sayHello(HttpResponse response){
        return "/index";
    }
}

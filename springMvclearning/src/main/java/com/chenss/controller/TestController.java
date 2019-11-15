package com.chenss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController {
    @RequestMapping("/test.do")
    @ResponseBody
    public Object test(String name, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("被调用了  " +name);
        System.out.println(request.getParameter("name"));
        return null;
    }
}

package com.chenss.controller;

import com.chenss.annotation.Controller;
import com.chenss.annotation.RequestMapping;
import com.chenss.annotation.ResponseBody;
import com.chenss.dao.UserInfoParam;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

/**
 * @author User
 */
@Controller
@RequestMapping("/test")
public class ChenssTestController {
    @RequestMapping("/test.do")
    @ResponseBody
    public Object test(String name, HttpRequest httpRequest, HttpResponse httpResponse, UserInfoParam userInfoParam) {
        System.out.println(String.format("name:%s", name));
        System.out.println(String.format("httpRequest:%s", httpRequest));
        System.out.println(String.format("httpResponse:%s", httpResponse));
        System.out.println(String.format("userInfoParam:%s", userInfoParam));
        return "test";
    }

    @RequestMapping("/model.do")
    public Object model() {
        return "index";
    }
}

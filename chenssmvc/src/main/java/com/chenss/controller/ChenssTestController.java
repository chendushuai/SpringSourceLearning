package com.chenss.controller;

import com.chenss.annotation.Controller;
import com.chenss.annotation.RequestMapping;
import com.chenss.annotation.ResponseBody;
import com.chenss.dao.UserInfoParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author User
 */
@Controller
@RequestMapping("/test")
public class ChenssTestController {
    @RequestMapping("/test.do")
    @ResponseBody
    public Object test(String name, HttpServletRequest httpRequest, HttpServletResponse httpResponse, UserInfoParam userInfoParam) {
        System.out.println(String.format("name:%s", name));
        System.out.println(String.format("HttpServletRequest:%s", httpRequest));
        System.out.println(String.format("HttpServletResponse:%s", httpResponse));
        System.out.println(String.format("userInfoParam:%s", userInfoParam));
        return "test";
    }

    @RequestMapping("/model.do")
    public Object model() {
        return "index";
    }
}

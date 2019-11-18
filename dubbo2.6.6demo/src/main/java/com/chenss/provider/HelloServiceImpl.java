package com.chenss.provider;

import com.chenss.api.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String userName) {
        return "Hello World!";
    }
}

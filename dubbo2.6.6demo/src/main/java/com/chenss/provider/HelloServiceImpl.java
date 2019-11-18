package com.chenss.provider;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.RpcContext;
import com.chenss.api.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String userName) {
        URL url = RpcContext.getContext().getUrl();
        System.out.println("hello " + userName);
        return String.format("Hello World! port:%s, host:%s", url.getPort(),url.getHost());
    }
}

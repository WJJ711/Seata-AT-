package com.wjj;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author wjj
 * @version 1.0
 * @date 2019/11/26 23:44
 */

@Component
@Service
public class HelloServiceImpl implements HelloServiceAPI {
    @Override
    public String sayHello(String str) {
        return "1234->"+str;
    }
}

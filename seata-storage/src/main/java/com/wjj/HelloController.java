package com.wjj;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjj
 * @version 1.0
 * @date 2019/11/26 23:45
 */
@RestController
public class HelloController {

    @Reference(check = false)
    HelloServiceAPI helloServiceAPI;

    @RequestMapping("/hello")
    public String helloTest(){
        return helloServiceAPI.sayHello("wjjtiancai");
    }
}

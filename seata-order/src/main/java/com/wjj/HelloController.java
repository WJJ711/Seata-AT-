package com.wjj;

import com.wjj.dao.OrderMapper;
import com.wjj.model.Order;
import lombok.extern.log4j.Log4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjj
 * @version 1.0
 * @date 2019/11/26 23:45
 */
@RestController
@Log4j
public class HelloController {

/*    @Reference(check = false)
    private HelloServiceAPI helloServiceAPI;*/

    @Autowired
    private OrderMapper orderMapper;
    @RequestMapping("/hello")
    public String helloTest(){
        log.info("test log");
        Order order = new Order();
        order.setUserId("wjj2");
        orderMapper.insertSelective(order);
        return "123";
    }
}

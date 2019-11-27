package com.wjj.controller;


import com.wjj.business.IBussinessService;
import com.wjj.order.IOrderService;
import com.wjj.storage.IStorageService;
import lombok.extern.log4j.Log4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjj
 * @version 1.0
 * @date 2019/11/27 13:52
 */
@RestController
@Log4j
public class BusinessController {

    @Reference(check = false)
    private IOrderService iOrderService;

    @RequestMapping("/buy")
    public void purchase(String userId,String commodityCode,int orderCount){
       iOrderService.create(userId,commodityCode,orderCount);
    }
}

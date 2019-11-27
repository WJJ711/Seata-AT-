package com.wjj.service;

import com.wjj.business.IBussinessService;
import com.wjj.order.IOrderService;
import com.wjj.storage.IStorageService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.log4j.Log4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @author wjj
 * @version 1.0
 * @date 2019/11/27 18:00
 */
@Component
@Log4j
public class BusinessServiceImpl implements IBussinessService {

    @Reference(check = false)
    private IStorageService iStorageService;

    @Reference(check = false)
    private IOrderService iOrderService;

    @Override
    @GlobalTransactional(timeoutMills = 300000)
    public void purchase(String userId, String commodityCode, int orderCount) {
        log.info("开始购买");
        log.info("Bussiness service...xid...->"+ RootContext.getXID());
        iStorageService.deduct(commodityCode,orderCount);
     /*   if (orderCount==1){
            throw new RuntimeException("testtest");
        }*/
        iOrderService.create(userId,commodityCode,orderCount);

        if (orderCount == 1) {
            throw new RuntimeException("Ordertest");
        }
        log.info("购买结束");
    }
}

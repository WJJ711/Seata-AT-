package com.wjj.service;

import com.wjj.account.IAccountService;
import com.wjj.dao.OrderMapper;
import com.wjj.model.Order;
import com.wjj.order.IOrderService;
import com.wjj.storage.IStorageService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author wjj
 * @version 1.0
 * @date 2019/11/27 18:08
 */
@Component
@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Reference(check = false)
    private IAccountService iAccountService;

    @Reference(check = false)
    private IStorageService iStorageService;

    @Override
    @GlobalTransactional
    public Order create(String userId, String commodityCode, int orderCount) {
        log.info("生成订单开始.......");
        log.info("order service...xid...->"+ RootContext.getXID());

        iStorageService.deduct(commodityCode,orderCount);

        if (orderCount == 2) {
            throw new RuntimeException("Ordertest");
        }
        //计算订单金额
        int orderMoney = calculate(commodityCode, orderCount);
        //从账户余额扣款
        iAccountService.debit(userId,orderMoney);
        if (orderCount==3){
            throw new RuntimeException("Ordertest");
        }
        Order order = new Order();
        order.setUserId(userId);
        order.setAmount((double) orderMoney);
        order.setCommodityCode(commodityCode);
        order.setCount(orderCount);
        order.setOrderNo(UUID.randomUUID().toString().replace("-",""));
        orderMapper.insertSelective(order);
        Integer id = order.getId();
        log.info("生成订单结束，订单->"+id);
        if (orderCount==4){
            throw new RuntimeException("Ordertest");
        }
        return order;
    }

    private int calculate(String commodityId,int orderCount){
        return 100*orderCount;
    }
}

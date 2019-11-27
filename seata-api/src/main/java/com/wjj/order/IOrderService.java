package com.wjj.order;

import com.wjj.model.Order;

/**
 * @author wjj
 * @version 1.0
 * @date 2019/11/27 11:02
 */
public interface IOrderService {
    /**
     * 创建订单
     * @param userId         用户ID
     * @param commodityCode  商品编号
     * @param orderCount     订购数量
     * @return  生成的订单
     */
    Order create(String userId,String commodityCode,int orderCount);
}

package com.wjj.business;

/**
 * @author wjj
 * @version 1.0
 * @date 2019/11/27 10:57
 */
public interface IBussinessService {
    /**
     * 用户订购商品
     * @param userId         用户ID
     * @param commodityCode  商品编号
     * @param orderCount     订购数量
     */
    void purchase(String userId,String commodityCode,int orderCount);
}

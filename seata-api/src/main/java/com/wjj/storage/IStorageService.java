package com.wjj.storage;

/**
 * @author wjj
 * @version 1.0
 * @date 2019/11/27 11:13
 */
public interface IStorageService {
    /**
     * 扣减库存
     * @param commodityCode  商品编号
     * @param count          扣减数量
     */
    void deduct(String commodityCode,int count);
}

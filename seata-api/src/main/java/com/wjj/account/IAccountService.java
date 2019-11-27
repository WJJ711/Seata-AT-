package com.wjj.account;

/**
 * @author wjj
 * @version 1.0
 * @date 2019/11/27 10:56
 */
public interface IAccountService {
    /**
     * 余额扣款
     * @param userId 用户ID
     * @param money  扣款金额
     */
    void debit(String userId,int money);
}

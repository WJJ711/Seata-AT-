package com.wjj.service;

import com.wjj.account.IAccountService;
import com.wjj.dao.AccountMapper;
import io.seata.core.context.RootContext;
import lombok.extern.log4j.Log4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wjj
 * @version 1.0
 * @date 2019/11/27 18:43
 */
@Component
@Service
@Log4j
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void debit(String userId, int money) {
        log.info("开始扣减余额");
        log.info("account service...xid...->"+ RootContext.getXID());
        accountMapper.debit(userId,money);
        log.info("扣钱余额成功");
    }
}

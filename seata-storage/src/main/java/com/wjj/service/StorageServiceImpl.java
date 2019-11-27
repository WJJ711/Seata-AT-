package com.wjj.service;

import com.wjj.dao.StorageMapper;
import com.wjj.storage.IStorageService;
import io.seata.core.context.RootContext;
import lombok.extern.log4j.Log4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wjj
 * @version 1.0
 * @date 2019/11/27 18:57
 */
@Service
@Component
@Log4j
public class StorageServiceImpl implements IStorageService {

    @Autowired
    private StorageMapper storageMapper;
    @Override
    public void deduct(String commodityCode, int count) {
        log.info("扣减库存开始............");
        log.info("storage service...xid...->"+ RootContext.getXID());
        storageMapper.deduct(commodityCode,count);
        log.info("扣减库存成功");
    }
}

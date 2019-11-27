package com.wjj.config;

import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wjj
 * @version 1.0
 * @date 2019/11/27 20:48
 */
@Configuration
public class SeataAutoConfig {

    @Bean
    public GlobalTransactionScanner globalTransactionScanner(){
        return new GlobalTransactionScanner("bussiness","my_test_tx_group");
    }
}

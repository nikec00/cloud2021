package com.cloud.service.impl;

import com.cloud.dao.OrderDAO;
import com.cloud.domain.Order;
import com.cloud.service.AccountService;
import com.cloud.service.OrderService;
import com.cloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/10/21 20:37
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;


    @Override
    @GlobalTransactional
    public void create(Order order) {
        log.info("---->开始新建订单");
        orderDAO.create(order);
        log.info("--->订单微服务开始调用库存，做扣减count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("--->订单微服务开始调用库存，做扣减end");
        log.info("--->订单微服务开始调用账户，做扣减money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("--->订单微服务开始调用账户，做扣减end");
        log.info("--->修改订单状态");
        orderDAO.update(order.getUserId(),0);
        log.info("--->修改订单状态结束");

        log.info("--->下订单，结束了，哈哈！！！");
    }

}

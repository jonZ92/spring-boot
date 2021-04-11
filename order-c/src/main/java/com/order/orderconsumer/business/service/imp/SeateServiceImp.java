package com.order.orderconsumer.business.service.imp;

import com.alibaba.dubbo.config.annotation.Reference;
import com.order.ordercommon.User;
import com.order.orderconsumer.business.dao.UserDao;
import com.order.orderconsumer.business.service.SeateService;
import com.order.orderprovider.business.service.UserServices;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeateServiceImp implements SeateService {

    @Reference(version = "1.0.0")
    private UserServices orderService;

    @Autowired
    private UserDao userDao;


    /**
     *
     * @param user
     * 分布式事物
     */
    @Override
    @GlobalTransactional(name = "fsp-create-orfer",rollbackFor = Exception.class)
    public void inserts(User user) {
        Integer i=userDao.counts().intValue();
        user.setId(i+1);
        orderService.insertInto(user);
        user.setId(i+2);
        userDao.insertUser(user);
    }
}

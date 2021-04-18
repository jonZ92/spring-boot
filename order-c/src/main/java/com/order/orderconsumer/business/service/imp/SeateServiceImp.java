package com.order.orderconsumer.business.service.imp;

import com.order.ordercommon.User;
import com.order.orderconsumer.business.dao.UserDao;
import com.order.orderconsumer.business.service.SeateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeateServiceImp implements SeateService {


    @Autowired
    private UserDao userDao;


    @Override
    public void inserts(User user) {

    }
}

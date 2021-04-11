package com.order.orderprovider.business.service.imp;



import com.alibaba.dubbo.config.annotation.Service;
import com.order.ordercommon.User;

import com.order.orderprovider.business.dao.UserDao;
import com.order.orderprovider.business.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(version = "1.0.0")
public class UserServiceImp implements UserServices {
    @Autowired
    private UserDao userDao;

    @Override
    public void insertInto(User user) {
        userDao.insertUser(user);
    }
}

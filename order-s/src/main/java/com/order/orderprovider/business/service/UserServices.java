package com.order.orderprovider.business.service;


import com.order.ordercommon.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserServices {

    void insertInto(User user);
}

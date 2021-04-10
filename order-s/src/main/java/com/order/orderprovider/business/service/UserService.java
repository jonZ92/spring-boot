package com.order.orderprovider.business.service;

import com.order.orderprovider.business.pageUtils.PageResult;
import com.order.orderprovider.business.pojo.User;


import java.util.List;

public interface UserService {

    List<User> selectPage(User user);
    PageResult findPage(Integer pageNum, Integer pageSize, User user);
}

package com.order.orderprovider.business.service;

import com.order.orderprovider.business.pageUtils.PageResult;
import com.order.orderprovider.business.pojo.User;

public interface UserService {

    PageResult findPage(Integer pageNum, Integer pageSize, User user);
}

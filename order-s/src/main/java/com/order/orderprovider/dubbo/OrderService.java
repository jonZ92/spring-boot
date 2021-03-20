package com.order.orderprovider.dubbo;

import com.order.ordercommon.UserInfo;


public interface OrderService {
    UserInfo getUserById(Long userId);
}

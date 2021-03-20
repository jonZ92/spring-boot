package com.order.orderprovider.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.order.ordercommon.UserInfo;
import com.order.orderprovider.dubbo.OrderService;
import org.springframework.stereotype.Component;

/**
 * @Auther: 吴宸煊
 * @Date: 2019/1/15
 * @Description:
 */
@Component
@Service(version = "1.0.0")
public class OrderServiceImpl implements OrderService {
    @Override
    public UserInfo getUserById(Long userId) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId((long) 10.00);
        userInfo.setUserName("测试数据");
        return userInfo;
    }
}

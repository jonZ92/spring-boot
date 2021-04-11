package com.order.orderconsumer.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.order.ordercommon.UserInfo;
import com.order.orderprovider.dubbo.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboConsumerController {
    @Reference(version = "1.0.0")
    private OrderService orderService;

    @RequestMapping("/")
    public UserInfo index() {
        return orderService.getUserById(Long.valueOf(1));
    }
}

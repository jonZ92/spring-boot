package com.order.orderconsumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@EnableDubboConfiguration
public class OrderConsumerApplication  {

    public static void main(String [] args) {
        SpringApplication.run(OrderConsumerApplication.class, args);
    }

}


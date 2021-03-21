package com.order.orderconsumer.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName ConsumerListener
 * @Description TD
 * @Author jon
 * @Date 2021/3/20 下午10:35
 * @Version 1.0
 * @Return:
 **/

@Component
public class ConsumerListener {
    private Logger logger = LoggerFactory.getLogger(ConsumerListener.class);

    @KafkaListener(id = "foo", topics = "testtopic")
    public void listen1(String foo) {
        logger.info("message content [{}]", foo);
    }

}

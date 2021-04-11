package com.order.orderprovider.kafka.utils;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName KafkaInitialConfiguration
 * @Description TD
 * @Author jon
 * @Date 2021/3/21 下午12:51
 * @Version 1.0
 * @Return:
 **/

@Configuration
public class KafkaInitialConfiguration {
    // 创建一个名为testtopic的Topic并设置分区数为8，分区副本数为2
//    @Bean
//    public NewTopic initialTopic() {
//        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//        return new NewTopic("testtopic",8, (short) 2 );
//    }
//
//    // 如果要修改分区数，只需修改配置值重启项目即可
//    // 修改分区数并不会导致数据的丢失，但是分区数只能增大不能减小
//    @Bean
//    public NewTopic updateTopic() {
//        return new NewTopic("testtopic",10, (short) 2 );
//    }
}

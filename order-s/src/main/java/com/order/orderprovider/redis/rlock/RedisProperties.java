package com.order.orderprovider.redis.rlock;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName RedisProperties
 * @Description TD
 * @Author jon
 * @Date 2021/3/21 上午12:35
 * @Version 1.0
 * @Return:
 **/
@ConfigurationProperties(prefix = "spring.redis", ignoreUnknownFields = false)
@Data
@ToString
public class RedisProperties {


    private int database;
    private int timeout;
    private String password;
    private String mode;
    private RedisPoolProperties pool;
    private RedisSingleProperties single;
    private RedisClusterProperties cluster;

    private RedisSentinelProperties sentinel;

}

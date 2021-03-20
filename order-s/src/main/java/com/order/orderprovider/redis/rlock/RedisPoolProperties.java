package com.order.orderprovider.redis.rlock;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName RedisPoolProperties
 * @Description TD
 * @Author jon
 * @Date 2021/3/21 上午12:39
 * @Version 1.0
 * @Return:
 **/
@Data
@ToString
public class RedisPoolProperties {
    private int maxIdle;
    private int minIdle;
    private int maxActive;

    private int maxWait;
    private int connTimeout;
    private int soTimeout;
    private  int size;

}

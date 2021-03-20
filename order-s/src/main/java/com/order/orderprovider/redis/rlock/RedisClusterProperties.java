package com.order.orderprovider.redis.rlock;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName RedisClusterProperties
 * @Description TD
 * @Author jon
 * @Date 2021/3/21 上午12:41
 * @Version 1.0
 * @Return:
 **/
@Data
@ToString

public class RedisClusterProperties {
    private int scanInterval;
    private String nodes;
    private String readMode;
    private int slaveConnectionPoolSize;
    private int masterConnectionPoolSize;
    private int retryAttempts;
    private int retryInterval;

    private int failedAttempts;




}

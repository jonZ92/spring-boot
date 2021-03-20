package com.order.orderprovider.redis.rlock;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName RedisSentinelProperties
 * @Description TD
 * @Author jon
 * @Date 2021/3/21 上午12:42
 * @Version 1.0
 * @Return:
 **/
@Data
@ToString

public class RedisSentinelProperties {
    private String master;
    private String nodes;
    private boolean masterOnlyWrite;
    private int failMax;

}

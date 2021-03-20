package com.order.orderprovider.redis.rlock;



import io.micrometer.core.instrument.util.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @ClassName CacheConfiguration
 * @Description TD
 * @Author jon
 * @Date 2021/3/21 上午12:42
 * @Version 1.0
 * @Return:
 **/
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class CacheConfiguration {
    @Autowired
    RedisProperties redisProperties;
    @Bean
    @ConditionalOnProperty(name = "spring.redis.mode", havingValue = "single")
    RedissonClient redissonSingle() {
        Config config = new Config();
        String node = redisProperties.getSingle().getAddress();
        node = node.startsWith("redis://") ? node : "redis://" + node;
        SingleServerConfig serverConfig = config.useSingleServer().setAddress(node)
                .setTimeout(redisProperties.getPool().getConnTimeout())
                .setConnectionPoolSize(redisProperties.getPool().getSize())
                .setConnectionMinimumIdleSize(redisProperties.getPool().getMinIdle());
        if (StringUtils.isNotBlank(redisProperties.getPassword())) {
            serverConfig.setPassword(redisProperties.getPassword());
        }
        return Redisson.create(config);
    }



}

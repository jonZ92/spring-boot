package com.order.orderprovider.redis.test;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName RedisController
 * @Description TD
 * @Author jon
 * @Date 2021/3/21 上午2:07
 * @Version 1.0
 * @Return:
 **/
@RequestMapping
@Controller
public class RedisController {

    @Autowired
    RedissonClient redisson;
    @Autowired
    RedisTemplate<String ,Object> redisTemplate;

    @GetMapping("/redis")
    @ResponseBody
    public String redis(String name) {
        RLock lock = redisson.getLock(name);

        redisTemplate.opsForValue().set("xx","sdasdasd");
        try {
            lock.lock(100L, TimeUnit.SECONDS);

            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }finally {
            lock.unlock();
        }



        return "success";
    }


}

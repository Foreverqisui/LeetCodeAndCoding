package com.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author foreverqisui
 */
@Controller
@RequestMapping("/redis")

public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;


    @PostMapping("/test/{id}/{value}")
    @ResponseBody
    public Object test(@PathVariable String id,
                       @PathVariable String value) {

        redisTemplate.opsForValue().set(id, value);
        return "a good day";
    }

    @GetMapping("/test/{id}")
    @ResponseBody
    public int testGet(@PathVariable String id) {
        redisTemplate.opsForValue().get(id);
        return 1;
    }
}

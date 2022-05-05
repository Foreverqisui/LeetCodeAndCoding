package com.pc.controller;

import com.pc.entry.TestData;
import com.pc.rabbitmq.MQSender;
import com.pc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyGadController {

    @Autowired
    TestService testService;

    @Autowired

    private MQSender mqSender;

    /**
     * 用来测试security的安全配置策略
     * */
    @RequestMapping("/")
    public String securityTest(){
        return "hello Security";
    }
    /**
     * 指定用户权限进行登录
     * */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/loginSecurity")
    public String loginTestBySecurity(){
        return "login Security";
    }
    /**
     * mysql连接linux测试
     * */
    @GetMapping(value = "/mysql/{id}")
    public String testGetMysql(@PathVariable Integer id) {
        TestData byId = testService.getById(id);
        return byId.toString();
    }

    /**
     * rabbitmq发送测试
     * */
    @RequestMapping(value = "/rabbitmq")
    public void mqTest(){
        mqSender.send("hello,rabbitmq");
    }
}

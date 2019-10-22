package com.goingao.develop;

import com.example.demo.service.RocketMqService;
import com.wisdom.stat.HelloServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@SpringBootApplication
@RestController
public class DevelopApplication {
    @Autowired
    private HelloServiceConfiguration helloService;
    @Autowired
    private RocketMqService rocketMqService;

    public static void main(String[] args) {
        SpringApplication.run(DevelopApplication.class, args);
    }

    @RequestMapping("/name")
    public String getName() {
        return helloService.getName();
    }

    @RequestMapping("/hobby")
    public String getHobby() {
        return helloService.getHobby();
    }

    @RequestMapping("/rockMq")
    public String getTopic() {
        return rocketMqService.getTopic();
    }
}

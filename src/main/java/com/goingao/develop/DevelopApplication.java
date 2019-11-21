package com.goingao.develop;

import com.example.demo.service.RocketMqService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wisdom.stat.HelloServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@DefaultProperties(defaultFallback = "defaultFail")
@EnableHystrix  //启动Hystrix
@EnableHystrixDashboard //启动可视化数据Dashboard
public class DevelopApplication {
    @Autowired
    private HelloServiceConfiguration helloService;
    @Autowired
    private RocketMqService rocketMqService;

    public static void main(String[] args) {
        SpringApplication.run(DevelopApplication.class, args);
    }

    @RequestMapping("/name")
    @HystrixCommand(fallbackMethod = "fail1")
    public String getName() {
        throw new RuntimeException();
//        return helloService.getName();
    }

    @HystrixCommand(fallbackMethod = "fail2")
    @RequestMapping("/test2")
    public String test2() {
        throw new RuntimeException();
    }

    @HystrixCommand(fallbackMethod = "fail3")
    private String fail2() {
        System.out.println("fail2");
        throw new RuntimeException();
    }

    @HystrixCommand
    private String fail3() {
        System.out.println("fail3");
        throw new RuntimeException();
    }

    private String fail1() {
        System.out.println("fail1");
        return "fail1";
    }

    @RequestMapping("/hobby")
    public String getHobby() {
        return helloService.getHobby();
    }

    @RequestMapping("/rockMq")
    public String getTopic() {
        return rocketMqService.getTopic();
    }

    private String defaultFail() {
        System.out.println("default fail");
        return "default fail";
    }
}

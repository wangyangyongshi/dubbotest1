package com.wzb.consumer.controller;


import com.wzb.service.TestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;


/**
 * @author Satsuki
 * @time 2019/8/27 15:58
 * @description:
 * 调用dubbo
 */
@RestController
public class TestController {

//    @Resource
//    private TestService testService;
    @Reference(url = "dubbo://localhost:20880",version = "1.0.0",timeout = 6000)
    private TestService TestServiceImpl;

    @RequestMapping("/ins")
    public String ins() {
        TestServiceImpl.ins();
        return "ins";
    }

    @RequestMapping("/del")
    public String del(){
        TestServiceImpl.del();
        return "del";
    }

    @RequestMapping("/upd")
    public String upd(){
        TestServiceImpl.upd();
        return "upd";
    }

    @RequestMapping("/sel")
    public String sel(){
        TestServiceImpl.sel();
        return "sel";
    }
}

package com.ufi.pdioms.resource.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRest {

    @GetMapping("/testRest")
    public String testRestTest(){

        return "接口调用测试！！";
    }

}

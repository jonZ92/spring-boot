package com.order.orderconsumer.business.controller;


import com.order.ordercommon.User;
import com.order.orderconsumer.business.service.imp.SeateServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeateController {


    @Autowired
    private SeateServiceImp seateService;


    @GetMapping(value ="/insert")
    @ResponseBody
    public String insert( @RequestBody User user){
        seateService.inserts(user);
        return "sucess";
    }

}

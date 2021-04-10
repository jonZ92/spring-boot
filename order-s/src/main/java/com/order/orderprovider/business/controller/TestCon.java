package com.order.orderprovider.business.controller;



import com.order.orderprovider.business.pojo.User;
import com.order.orderprovider.business.service.imp.serServiceImpl;
import com.order.orderprovider.business.pageUtils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class TestCon {


    @Autowired
    private serServiceImpl sx;

    @GetMapping(value ="/sc/{pageNum}/{pageSize}")
    @ResponseBody
    public PageResult test(@PathVariable(name = "pageNum") Integer pageNum, @PathVariable(name = "pageSize") Integer pageSize, @RequestBody User user){

        return sx.findPage(pageNum,pageSize,user);
    }


}

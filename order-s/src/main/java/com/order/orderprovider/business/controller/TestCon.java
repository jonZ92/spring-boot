package com.order.orderprovider.business.controller;



import com.order.orderprovider.business.pojo.User;
import com.order.orderprovider.business.service.imp.serServiceImpl;
import com.order.orderprovider.business.pageUtils.PageResult;
import com.order.orderprovider.hadoop.HdfsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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


    @RequestMapping(value = "mkdir", method = RequestMethod.POST)
    @ResponseBody
    public String mkdir(@RequestParam("path") String path) throws Exception {

        HdfsService.mkdir("path");

        return "xxxx";
    }


    @RequestMapping(value = "/createFile", method = RequestMethod.POST)
    @ResponseBody
    public String createFile(@RequestParam("createFile") String path,@RequestParam("file") MultipartFile file) throws Exception {

        HdfsService.createFile("path",file);

        return "xxxxxxxxxxxxxx";
    }
    //createFile

    @RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
    @ResponseBody
    public String deleteFile(@RequestParam("path") String path) throws Exception {

        HdfsService.deleteFile("path");

        return "xxxxxxxxxxxxxx";
    }


}

package com.order.orderprovider.business.controller;


import com.order.orderprovider.business.pageUtils.PageResult;
import com.order.orderprovider.business.pojo.User;
import com.order.orderprovider.business.service.imp.UserServiceImp;
import com.order.orderprovider.business.service.imp.serServiceImpl;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping
public class TestCon {


    @Autowired
    private serServiceImpl sx;

    @Autowired
    private UserServiceImp userServiceImp;


    @GetMapping(value = "/sc/{pageNum}/{pageSize}")
    @ResponseBody
    public PageResult test(HttpServletResponse response, HttpServletRequest request, @PathVariable(name = "pageNum") Integer pageNum, @PathVariable(name = "pageSize") Integer pageSize, @RequestBody(required = false) User user) {
        response.setHeader("Set-Cookie","ssssssssssadasdasdad");
        return sx.findPage(pageNum, pageSize, user);
    }


    @GetMapping("/insa")
    @ResponseBody
    public String gets(){
        com.order.ordercommon.User u=new  com.order.ordercommon.User();
        u.setAge(1023);
        u.setName("sdas");
        u.setId(14245);
        userServiceImp.insertInto(u);
        return "sue";
    }


//    @RequestMapping(value = "mkdir", method = RequestMethod.POST)
//    @ResponseBody
//    public String mkdir(@RequestParam("path") String path) throws Exception {
//
//        HdfsService.mkdir("path");
//
//        return "xxxx";
//    }

//
//    @RequestMapping(value = "/createFile", method = RequestMethod.POST)
//    @ResponseBody
//    public String createFile(@RequestParam("createFile") String path,@RequestParam("file") MultipartFile file) throws Exception {
//
//        HdfsService.createFile("path",file);
//
//        return "xxxxxxxxxxxxxx";
//    }
//    //createFile
//
//    @RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
//    @ResponseBody
//    public String deleteFile(@RequestParam("path") String path) throws Exception {
//
//        HdfsService.deleteFile("path");
//
//        return "xxxxxxxxxxxxxx";
//    }


    @GetMapping("/dowm")
    public void downTest(HttpServletResponse response) throws Exception {
        InputStream inputStream = null;
            File file = new File("/home/jon/soft/撒看你的阿萨德了.zip");
            inputStream = new FileInputStream(file);
            String filename = "撒看你的阿萨德了.zip";
            filename = new String(filename.getBytes("GB2312"), StandardCharsets.ISO_8859_1);
            response.setContentType("application/octet-stream");
            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;filename=" + filename);
            IOUtils.copy(inputStream,response.getOutputStream());
    }
}

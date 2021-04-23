package com.order.orderprovider.mongodb;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName MdbController
 * @Description TD
 * @Author jon
 * @Date 2021/3/22 下午3:41
 * @Version 1.0
 * @Return:
 **/
@RestController
public class MdbController {


    @Autowired
    private MongoTemplate mongoTemplate;



    @GetMapping("/mongo")
    @ResponseBody
    public String mongo(String  name){
        User u=new User();
        u.setName("zhangsan");
        u.setAge("40");
        u.setAddress("中国");
        u.setNums("12345");
        u.setSex("man");
        mongoTemplate.save(u);
        Query query=new Query(new Criteria());
        //Query query=new Query();
        User users = mongoTemplate.findOne(query, User.class);
        List<User> all = mongoTemplate.findAll(User.class);
        all.forEach(a->{
            System.out.println(a.toString());
        });
        if (users==null){
            return "没查到";
        }
        return all.toString();
    }


    @GetMapping("/files")
    @ResponseBody
    public String saveFile()throws Exception{
        File file = new File("/home/jon/soft/unnamed.jpg");
        FileInputStream in = new FileInputStream(file);
        long size=in.available();
        byte [] bytes=new byte[(int) size];
        in.read(bytes);
        Mong0s mong0s=new Mong0s();
        mong0s.setName("unnamed.jpg");
        mong0s.setContent(new Binary(bytes));
        mong0s.setCreatedTime(LocalDateTime.now());
        mong0s.setContentType("xxxxx");
        mong0s.setSize(size);
        mongoTemplate.save(mong0s);
        in.close();
        return "xxxxxxx";
    }
    @GetMapping("/getfiles")
    @ResponseBody
    public String getFiles()throws Exception{
        Criteria criteria=Criteria.where("nane").ne("unnamed.jpg");
        Query query=new Query(criteria);
        Mong0s one = mongoTemplate.findOne(query, Mong0s.class);
        byte [] bytes=new byte[(int)one.getSize()];
        bytes=one.getContent().getData();
        FileOutputStream out = new FileOutputStream("/home/jon/soft/xxxx.jpg");
        out.write(bytes);
        out.close();
        return "xxxxxxx";
    }
}

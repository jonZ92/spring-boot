package com.order.orderprovider.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
        // mongoTemplate.save(u);
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
        return users.toString();
    }
}

package com.order.orderconsumer.business.dao;

import com.order.ordercommon.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    void insertUser(User user);

    Integer counts();

}

package com.order.orderprovider.business.dao;


import com.order.orderprovider.business.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface SysUserMapper {


    /**
     * 分页查询用户
     * @return
     */
   List<User> selectPage(User user);
   void deleteData(Map map);

}


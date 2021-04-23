package com.order.orderprovider.business.service.imp;




import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.order.orderprovider.business.dao.SysUserMapper;
import com.order.orderprovider.business.pageUtils.PageResult;
import com.order.orderprovider.business.pageUtils.PageUtils;
import com.order.orderprovider.business.pageUtils.Pages;
import com.order.orderprovider.business.pojo.User;
import com.order.orderprovider.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class serServiceImpl implements UserService {


    @Autowired
    private SysUserMapper sysUserMapper;





    @Override
    public PageResult findPage(Integer pageNum, Integer pageSize, User user) {

        //sysUserMapper.deleteData(new HashMap(){{put("phone","1");}});
        return PageUtils.getPageResult(new Pages<User>() {
            @Override
            public PageInfo<User> getPageInfo(Integer pageNum, Integer pageSize, User user) {
                PageHelper.startPage(pageNum, pageSize);
                return new PageInfo<User>(sysUserMapper.selectPage(user));
            }
        }.getPageInfo(pageNum, pageSize, user));
    }
}

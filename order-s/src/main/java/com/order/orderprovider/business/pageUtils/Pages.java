package com.order.orderprovider.business.pageUtils;

import com.github.pagehelper.PageInfo;

@FunctionalInterface
public interface Pages<T> {

        PageInfo<T> getPageInfo(Integer pageNum, Integer pageSize, T user );

}

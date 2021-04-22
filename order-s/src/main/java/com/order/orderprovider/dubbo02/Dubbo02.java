package com.order.orderprovider.dubbo02;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.config.annotation.Service;
import com.order.ordercommon.service.DubboJ;
import org.springframework.stereotype.Component;

@Component
@Service(version = "1.0.0")
public class Dubbo02 implements DubboJ {
    @Override
    public String getDubbo(String str) {
        return str;
    }

}

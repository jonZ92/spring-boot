package com.order.orderconsumer.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.order.ordercommon.service.DubboJ;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

import java.io.InputStream;

@RestController
public class DubboConsumerController {

    @Reference(version = "1.0.0")
    private DubboJ dubboJ;


    @RequestMapping("/dubbo2")
    @ResponseBody
    public String getDubbo(String str, HttpServletRequest request) throws Exception {
        InputStream inputStream = request.getInputStream();
        return dubboJ.getDubbo(str);
    }

}

package com.ruoyi.web.controller.common;


import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/rule")
public class RuleHandler {

    @GetMapping("/{prefix}")
    public String list(@PathVariable String prefix)
    {
        //订单前缀默认为CN 如果规则参数不为空，则取自定义前缀
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        int random = RandomUtils.nextInt(0, 10) + 10;
        String value = prefix + format.format(new Date()) + random;
        return value;
    }
}

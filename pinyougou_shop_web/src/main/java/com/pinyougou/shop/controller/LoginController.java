package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: pinyougou_parent
 * @description: 获取到登陆的用户名
 * @author: YF
 * @create: 2018-07-12 20:44
 **/
@RestController
@RequestMapping("/login")
public class LoginController {
    //获取到登陆的用户名
    @RequestMapping("/name")
    @ResponseBody
    public Map<String,Object> name(){
        //获取到权限框架中的值
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, Object> map = new HashMap<>();
        map.put("loginName", name);
        return map;
    }

}

package com.pinyougou.sellergoods.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: pinyougou_parent
 * @description: 用户登陆的类
 * @author: YF
 * @create: 2018-07-08 21:10
 **/
@RestController
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/name")
    @ResponseBody
    public Map<String,Object> name(){
        //从权限的框架中拿到用户名的值
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String,Object>  map = new HashMap();
        map.put("loginName",name);
        return map;
    }
}

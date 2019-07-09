package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Street;
import com.team.house.entity.Users;
import com.team.house.service.StreetService;
import com.team.house.service.UserService;
import com.team.house.util.Page;
import com.team.house.util.UserCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王建兵
 * @Classname UserController
 * @Description TODO
 * @Date 2019/6/29 9:19
 * @Created by Administrator
 */
@Controller
@RequestMapping("/admin/")
public class StreetController {

    @Autowired
    private StreetService streetService;

    @RequestMapping("getStreetByDid")
    @ResponseBody
    public Map<String,Object> getStreetByDid(Integer id,Page page){
        //调用业务
        PageInfo<Street> pageInfo= streetService.getStreetByDid(id,page);

        Map<String,Object> objs=new HashMap<>();
        objs.put("total",pageInfo.getTotal());
        objs.put("rows",pageInfo.getList());
        return objs;
    }
}

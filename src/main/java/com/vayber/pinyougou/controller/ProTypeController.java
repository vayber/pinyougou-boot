package com.vayber.pinyougou.controller;


import com.vayber.pinyougou.bean.ProType;
import com.vayber.pinyougou.service.proType.ProTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proType")
public class ProTypeController {

    @Autowired
    ProTypeService typeService;

    @RequestMapping("/getProTypeList")
    @Cacheable(cacheNames = "proType",key = "#root.methodName")
    public List<ProType> getProTypeList(){
        return typeService.list();
    }

}

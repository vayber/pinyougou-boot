package com.vayber.pinyougou.controller;

import com.vayber.pinyougou.bean.PayInfo;
import com.vayber.pinyougou.service.payInfo.PayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/payInfo")
public class PayInfoController {

    @Autowired
    PayInfoService payInfoService;

        @RequestMapping("/query")

    public PayInfo getPayInfoById(@RequestParam(value = "id",defaultValue = "")Integer id)  {

        return payInfoService.getById(id);
    }

    @RequestMapping("/add")
    public String savePayInfo(PayInfo payInfo) {

        if(payInfoService.save(payInfo)){
            return "保存成功！";
        }else {
            return "保存失败！";
        }
    }
}

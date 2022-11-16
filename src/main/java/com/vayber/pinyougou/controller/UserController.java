package com.vayber.pinyougou.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.vayber.pinyougou.bean.User;
import com.vayber.pinyougou.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public User getLoginUser(@RequestParam(value = "userName",defaultValue = "") String userName,
                             @RequestParam(value = "password",defaultValue = "") String password) {

        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.eq("userName",userName);
        wrapper.eq("password",password);

        return userService.getOne(wrapper);
    }

    @RequestMapping("/alterUserPwd")
    public String alterUserPwd(@RequestParam(value = "id",defaultValue = "") Integer id,
                               @RequestParam(value = "password",defaultValue = "") String password){

        User user = new User();
        user.setId(id);
        user.setPassword(password);
        if (userService.updateById(user)){
            return "修改成功！";
        }else {
            return "修改失败！";
        }
    }

}

package com.vayber.pinyougou.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vayber.pinyougou.bean.Customer;
import com.vayber.pinyougou.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/login")
    public Customer getLoginCustomer(@RequestParam(value = "email",defaultValue = "") String email,
                                 @RequestParam(value = "emailPwd",defaultValue = "") String emailPwd)  {

        QueryWrapper<Customer> wrapper = new QueryWrapper<>();

        wrapper.eq("email",email);
        wrapper.eq("emailPwd",emailPwd);

        return customerService.getOne(wrapper,false);

    }

    @RequestMapping("/add")
    @CacheEvict(cacheNames = "customer",allEntries=true)
    public String addCustomer(Customer customer)  {

        if (customerService.save(customer)){
            return "注册成功！";
        }else {
            return "注册失败！";
        }
    }

    @RequestMapping("/delete")
    @CacheEvict(cacheNames = "customer",allEntries=true)
    public String deleteCustomer(@RequestParam(value = "id",defaultValue = "")Integer id){

        if (customerService.removeById(id)){
            return "注销成功！";
        }else {
            return "注销失败！";
        }

    }

    @RequestMapping("/alter")
    @CacheEvict(cacheNames = "customer",allEntries=true)
    public String alterCustomer(Customer customer){

        if (customerService.updateById(customer)){
            return "修改成功！";
        }else {
            return "修改失败！";
        }
    }

    @RequestMapping("/getCustomerList")
    @Cacheable(cacheNames = "customer",key = "#root.methodName+'['+#currentPage+']'")
    public List<Customer> getCustomerList( @RequestParam(value ="currentPage",defaultValue = "1")Integer currentPage,
                                           @RequestParam(value ="pageSize",required = false)Integer pageSize){

        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();

        Page<Customer> page = new Page<>(currentPage,pageSize);

        Page<Customer> customerPage = customerService.page(page, queryWrapper);

        List<Customer> records = customerPage.getRecords();

        return records;
    }

        @RequestMapping("/getCustomerListNoPage")
        @Cacheable(cacheNames = "customer",key = "#root.methodName")
    public List<Customer> getCustomerListNoPage( ){

        return customerService.list();
    }

    @RequestMapping("/getCustomerCount")
    @Cacheable(cacheNames = "customer",key = "#root.methodName")
    public Integer getCustomerCount(){
        return customerService.count();
    }
}

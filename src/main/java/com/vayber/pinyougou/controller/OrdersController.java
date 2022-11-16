package com.vayber.pinyougou.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vayber.pinyougou.bean.Orders;
import com.vayber.pinyougou.service.orders.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @RequestMapping("/getOrdersListById")
    @Cacheable(cacheNames = "orders",key = "#root.methodName+#customerId+'['+#currentPage+']'")
    public List<Orders> getOrdersById(@RequestParam(value = "customerId",defaultValue = "")Integer customerId,
                                      @RequestParam(value ="currentPage",defaultValue = "1")Integer currentPage,
                                      @RequestParam(value ="pageSize",required = false)Integer pageSize)  {


        QueryWrapper<Orders> wrapper = new QueryWrapper<>();

        wrapper.eq("customerId",customerId);

        wrapper.orderByDesc("creationDate");

        Page<Orders> page = new Page<>(currentPage,pageSize);

        Page<Orders> ordersPage = ordersService.page(page, wrapper);
        List<Orders> records = ordersPage.getRecords();
        return records;
    }

    @RequestMapping("/getOrdersCountById")
    @Cacheable(cacheNames = "orders",key = "#root.methodName+#customerId")
    public Integer getOrdersCountById(@RequestParam(value = "customerId",defaultValue = "")Integer customerId)  {

        QueryWrapper<Orders> wrapper = new QueryWrapper<>();
        wrapper.eq("customerId",customerId);

        return ordersService.count(wrapper);
    }

    @RequestMapping("/getOrdersList")
    @Cacheable(cacheNames = "orders",key = "#root.methodName+'['+#currentPage+']'")
    public List<Orders> getOrdersList( @RequestParam(value ="currentPage",defaultValue = "1")Integer currentPage,
                                       @RequestParam(value ="pageSize",required = false)Integer pageSize)  {

        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();

        queryWrapper.orderByDesc("creationDate");

        Page<Orders> page = new Page<>(currentPage,pageSize);

        Page<Orders> ordersPage = ordersService.page(page, queryWrapper);

        List<Orders> records = ordersPage.getRecords();

        return records;
    }

    @RequestMapping("/getOrdersCount")
    @Cacheable(cacheNames = "orders",key = "#root.methodName")
    public Integer getOrdersCount()  {

        return ordersService.count();
    }


//    @RequestMapping("/query")
//    public Orders  queryOrders(@RequestParam(value = "id",defaultValue = "")Integer id) {
//
//    return ordersService.getById(id);
//    }
    @RequestMapping("/delete")
    @CacheEvict(cacheNames = "orders",allEntries=true)
    public String  deleteOrders(@RequestParam(value = "id",defaultValue = "")Integer id) {
        if (ordersService.removeById(id)){
            return "删除成功！";
        }else {
            return "删除失败！";
        }
    }
    @RequestMapping("/alter")
    @CacheEvict(cacheNames = "orders",allEntries=true)
    public String  alterOrders(Orders orders){

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String modifyDate = simpleDateFormat.format(date);

        orders.setModifyDate(modifyDate);
        if (ordersService.updateById(orders)){
            return "修改成功！";
        }else {
            return "修改失败！";
        }

    }
    @RequestMapping("/add")
    @CacheEvict(cacheNames = "orders",allEntries=true)
    public String  addOrders(Orders orders)  {


        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String creationDate = simpleDateFormat.format(date);

        orders.setCreationDate(creationDate);

        if (ordersService.save(orders)){
            return "添加成功！";
        }else {
            return "添加失败！";
        }
    }
}

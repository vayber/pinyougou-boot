package com.vayber.pinyougou.service.orders;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vayber.pinyougou.bean.Orders;
import com.vayber.pinyougou.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
}

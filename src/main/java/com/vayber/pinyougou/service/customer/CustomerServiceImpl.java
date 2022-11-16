package com.vayber.pinyougou.service.customer;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vayber.pinyougou.bean.Customer;
import com.vayber.pinyougou.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {


}

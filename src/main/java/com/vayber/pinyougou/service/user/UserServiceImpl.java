package com.vayber.pinyougou.service.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vayber.pinyougou.bean.User;
import com.vayber.pinyougou.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

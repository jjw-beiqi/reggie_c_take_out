package com.reggiec.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.reggiec.entity.User;
import com.reggiec.mapper.UserMapper;
import com.reggiec.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
}

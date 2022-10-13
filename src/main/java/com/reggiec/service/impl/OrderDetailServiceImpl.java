package com.reggiec.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.reggiec.entity.OrderDetail;
import com.reggiec.mapper.OrderDetailMapper;
import com.reggiec.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>
        implements OrderDetailService {
}

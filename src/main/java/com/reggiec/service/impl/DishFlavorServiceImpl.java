package com.reggiec.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.reggiec.entity.DishFlavor;
import com.reggiec.mapper.DishFlavorMapper;
import com.reggiec.service.DishFlavorService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor>
        implements DishFlavorService {
}

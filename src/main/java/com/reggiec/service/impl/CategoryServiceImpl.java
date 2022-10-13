package com.reggiec.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.reggiec.entity.Category;
import com.reggiec.mapper.CategoryMapper;
import com.reggiec.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
        implements CategoryService {
}

package com.reggiec.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.reggiec.common.R;
import com.reggiec.entity.ShoppingCart;

public interface ShoppingCartService extends IService<ShoppingCart> {
    // 添加到购物车
    public ShoppingCart add(ShoppingCart shoppingCart);
}

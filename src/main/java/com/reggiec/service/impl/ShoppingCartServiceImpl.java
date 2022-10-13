package com.reggiec.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.reggiec.common.BaseContext;
import com.reggiec.common.R;
import com.reggiec.entity.ShoppingCart;
import com.reggiec.mapper.ShoppingCartMapper;
import com.reggiec.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart>
        implements ShoppingCartService {

    /**
     * 添加到购物车
     * @param shoppingCart
     * @return
     */
    @Override
    @Transactional
    public ShoppingCart add(ShoppingCart shoppingCart) {

        // 设置用户id，指定当前是哪个用户到购物车
        Long currentId = BaseContext.getCurrentId();
        shoppingCart.setUserId(currentId);


        // 查询购物车中是否有这个套餐或菜品
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId,currentId);
        Long dishId = shoppingCart.getDishId();
        if (dishId != null){
            queryWrapper.eq(ShoppingCart::getDishId,dishId);
        }else {
            queryWrapper.eq(ShoppingCart::getSetmealId,shoppingCart.getSetmealId());
        }

        ShoppingCart shoppingCartServiceOne = this.getOne(queryWrapper);


        if (shoppingCartServiceOne != null){
            // 查询当前添加的菜品或者套餐是否在购物车中，如果在就只要数量加一就好了
            Integer number = shoppingCartServiceOne.getNumber();
            shoppingCartServiceOne.setNumber(number+1);
            this.updateById(shoppingCartServiceOne);
        }else {
            // 不存在则添加到购物车，数量默认1
            shoppingCart.setNumber(1);
            shoppingCart.setUserId(currentId);
            shoppingCart.setCreateTime(LocalDateTime.now());
            this.save(shoppingCart);
            shoppingCartServiceOne = shoppingCart;
        }

        return shoppingCartServiceOne;
    }
}

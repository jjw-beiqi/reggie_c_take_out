package com.reggiec.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.reggiec.dto.SetmealDto;
import com.reggiec.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    // 新增套餐，同时要保存关联关系
    public void saveWithDish(SetmealDto setmealDto);

    // 删除套餐，同时删除套餐和菜品的关系
    public void removeWithDish(List<Long> ids);

    // 根据菜品id修改套餐状态
    public void updateStatus(Integer status, Long id);
}

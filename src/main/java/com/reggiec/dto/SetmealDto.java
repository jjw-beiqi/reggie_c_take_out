package com.reggiec.dto;

import com.reggiec.entity.Setmeal;
import com.reggiec.entity.SetmealDish;
import lombok.Data;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}

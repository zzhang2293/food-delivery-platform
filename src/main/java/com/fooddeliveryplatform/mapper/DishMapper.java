package com.fooddeliveryplatform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fooddeliveryplatform.domain.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}

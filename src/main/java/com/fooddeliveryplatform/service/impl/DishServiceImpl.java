package com.fooddeliveryplatform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fooddeliveryplatform.domain.Dish;
import com.fooddeliveryplatform.mapper.DishMapper;
import com.fooddeliveryplatform.service.DishService;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}

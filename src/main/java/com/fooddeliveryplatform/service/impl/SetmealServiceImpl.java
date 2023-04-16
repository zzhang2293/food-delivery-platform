package com.fooddeliveryplatform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fooddeliveryplatform.domain.Setmeal;
import com.fooddeliveryplatform.mapper.SetmealMapper;
import com.fooddeliveryplatform.service.SetmealService;
import org.springframework.stereotype.Service;

@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
}

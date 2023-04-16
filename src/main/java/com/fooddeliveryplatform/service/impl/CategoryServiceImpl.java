package com.fooddeliveryplatform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fooddeliveryplatform.domain.Category;
import com.fooddeliveryplatform.mapper.CategoryMapper;
import com.fooddeliveryplatform.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}

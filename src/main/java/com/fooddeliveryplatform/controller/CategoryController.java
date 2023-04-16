package com.fooddeliveryplatform.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fooddeliveryplatform.domain.Category;
import com.fooddeliveryplatform.result.Result;
import com.fooddeliveryplatform.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * category management
 */
@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Result<String> save(@RequestBody Category category){
        categoryService.save(category);
        return Result.success("success");
    }

    /**
     * pagination
     * @param page which page
     * @param pageSize total size
     * @return response
     */
    @GetMapping("/page")
    public Result<Page<Category>> pageResult(int page, int pageSize){
        Page<Category> pageInfo = new Page<>(page, pageSize);
        // condition variable
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Category::getSort);

        categoryService.page(pageInfo, queryWrapper);
        return Result.success(pageInfo);
    }

    @DeleteMapping
    public Result<String> delete(Long ids){
        log.info("delete category, id is : {}", ids);
        categoryService.removeById(ids);
        return Result.success("delete success");
    }

}

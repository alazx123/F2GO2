package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.entity.Employee;
import com.itheima.reggie.service.CategoryService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name) {


        //构造分页构造器
        Page pageInfo = new Page(page, pageSize);

        //构造条件构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper();

        //添加排序条件
        queryWrapper.orderByDesc(Category::getUpdateTime);

        //执行查询
        categoryService.page(pageInfo, queryWrapper);

        return R.success(pageInfo);
    }

    @PostMapping
    public R<String> add(@RequestBody Category category) {
        Boolean result = categoryService.add(category);
        R r = result == true ? R.success("Add successfully") : R.error("Add failure");
        return r;
    }

    @PutMapping
    public R<String> update(@RequestBody Category category) {
        Boolean result = categoryService.updateCategory(category);
        R r = result == true ? R.success("Update successflly") : R.error("Update failure");
        return r;
    }

    @DeleteMapping()
    public R<String> delete( Long ids) {
        System.out.println(ids);
        Boolean result = categoryService.deleteId(ids);
        R r = result == true ? R.success("Delete successflly") : R.error("Delete failure");
        return r;
    }

    @GetMapping("/list")
    public R<List<Category>> findByType(Integer type){
        List<Category> result = categoryService.findByType(type);
        return R.success(result);
    }
}

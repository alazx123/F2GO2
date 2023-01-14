package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.entity.Employee;

import java.util.List;

public interface CategoryService extends IService<Category> {
   Boolean deleteId(Long id) ;


    Boolean add(Category category);

   Boolean updateCategory(Category category);

   List<Category> findByType(Integer type);
}

package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.entity.Employee;
import com.itheima.reggie.mapper.CategoryMapper;
import com.itheima.reggie.mapper.EmployeeMapper;
import com.itheima.reggie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements CategoryService{
@Autowired
CategoryMapper categoryMapper;

    @Override
    public Boolean deleteId(Long id) {
        int i = categoryMapper.deleteId(id);
        Boolean result= i==1?true:false;
        return result;
    }

    @Override
    public Boolean add(Category category) {
        int r = categoryMapper.add(category);
        Boolean result = r ==1? true:false;
        return result;
    }

    @Override
    public Boolean updateCategory(Category category) {
        int i = categoryMapper.updateCategory(category);
        Boolean result = i==1?true:false;
        return result;

    }

    @Override
    public List<Category> findByType(Integer type) {
        List<Category> result = categoryMapper.findByType(type);
        return result;
    }
}
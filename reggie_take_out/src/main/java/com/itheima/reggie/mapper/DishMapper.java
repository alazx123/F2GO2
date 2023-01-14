package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.entity.Dish;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Mapper
@Repository
public interface DishMapper extends BaseMapper<Dish> {


    @Insert("insert into dish values(#{id},#{name},#{categoryId},#{price},#{code},#{image},#{description},#{status},#{sort},#{createTime},#{updateTime},#{createUser},#{updateUser},#{isDeleted})")
    int saveDish(Dish dish);

    @Select("select id from dish where name =#{name}")
    Long findDishByName(@Param("name") String name);
}

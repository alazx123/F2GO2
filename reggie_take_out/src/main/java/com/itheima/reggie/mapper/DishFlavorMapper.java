package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Dish;
import com.itheima.reggie.entity.DishFlavor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DishFlavorMapper extends BaseMapper<DishFlavor> {


    @Insert("insert into dish_flavor values(#{id},#{dishId},#{name},#{value},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    int saveFlavor(DishFlavor dishFlavor);
}

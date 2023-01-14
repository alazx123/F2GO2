package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.itheima.reggie.entity.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper extends BaseMapper<Category> {
    @Insert("insert into category values(#{id},#{type},#{name},#{sort},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    int  add(Category category);

    @Update("update category set name=#{name},sort=#{sort} where id=#{id} ")
    int updateCategory(Category category);

    @Delete("delete from category where id=#{id}")
    int  deleteId(Long id);

    @Select("select * from category where type=#{type}")
    List<Category> findByType(@Param("type") Integer type);
}

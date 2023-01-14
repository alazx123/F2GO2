package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EmployeeMapper extends BaseMapper<Employee>{

    @Update("update employee set username=#{username},name=#{name},phone=#{phone},sex=#{sex} where id=#{id}")
    void updateEmp(Employee employee);

    @Select("select * from employee where username=#{username}")
    Employee findByUsername(@Param("username") String username);

    @Insert("insert into employee values(#{id},#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    int insertEmp(Employee employee);

    @Select("select * from employee where id=#{id}")
    Employee findById(@Param("id") Long id);

    @Update("update employee set status=#{status} where id=#{id}")
   int updateStatus(Employee employee);
}

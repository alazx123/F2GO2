//package com.itheima.reggie.mapper;
//
//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.itheima.reggie.entity.Employee;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.annotations.Update;
//import org.springframework.stereotype.Repository;
//
//@Mapper
//@Repository
//public interface EmployeeMapper1 extends BaseMapper<Employee>{
//
//    @Select("select * from employee where id=#{id}")
//    Employee findById(@Param("id") Long id);
//
//    @Update("update employee set username=#{username},name=#{name},phone=#{phone},sex=#{sex} where id=#{id}")
//    void updateEmp(Employee employee);
//
//    @Select("select * from employee where username = #{username}")
//    Employee findByUsername(@Param("username") String username);
//
//    @Select("select * from employee where username=#{username} And password=#{password}")
//    Employee checkPassword(@Param("username") String username, @Param("password") String password);
//
//    @Select("insert into employee values(#{id},#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
//    void insertEmp(Employee employee);
//
//}

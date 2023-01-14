package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Employee;
import com.itheima.reggie.mapper.EmployeeMapper;
import com.itheima.reggie.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService{
    @Autowired
    EmployeeMapper employeeMapper;

    public R<Employee> loginService(Employee employee) {
        String username = employee.getUsername();
        String password = employee.getPassword();
        Employee byUsername = employeeMapper.findByUsername(username);
        String password1 = byUsername.getPassword();
        if (byUsername == null) {
            return R.error("Username invaild");
        } else if (!password.equals(password1)) {
            return R.error("Password invaild");
        } else if (byUsername.getStatus() != 1) {
            return R.error("User invalid");
        }
        return R.success(byUsername);
    }




    @Override
    public R<String> saveService(Employee employee, Long id) {
       employee.setPassword("12345678");
       employee.setCreateTime(LocalDateTime.now());
       employee.setUpdateTime(LocalDateTime.now());
       employee.setCreateUser(id);
       employee.setUpdateUser(id);
       employee.setStatus(1);
        int result = employeeMapper.insertEmp(employee);
        if (result==1){
            return R.success("Save successflly");
        }
        return R.error("Save failure");



    }

    @Override
    public Employee findById(Long id) {
        Employee result = employeeMapper.findById(id);
       return result;
    }

    @Override
    public R<String> updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
        return R.success("update successfully");
    }




}

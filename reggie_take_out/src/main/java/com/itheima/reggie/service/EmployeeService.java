package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Employee;

public interface EmployeeService extends IService<Employee> {


    public R<Employee> loginService(Employee employee);

    public R<String> saveService(Employee employee, Long id);

    public Employee findById(Long id);


    public R<String> updateEmp(Employee employee);


}

//package com.itheima.reggie.controller;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.itheima.reggie.common.R;
//import com.itheima.reggie.entity.Employee;
//import com.itheima.reggie.service.EmployeeService;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import java.time.LocalDateTime;
//
//@Slf4j
//@RestController
////@RequestMapping("/employee")
//public class EmployeeController1 {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//
//
//    /**
//     * 员工信息分页查询
//     * @param page
//     * @param pageSize
//     * @param name
//     * @return
//     */
//    @GetMapping("/page")
//    public R<Page> page(int page,int pageSize,String name){
//        log.info("page = {},pageSize = {},name = {}" ,page,pageSize,name);
//
//        //构造分页构造器
//        Page pageInfo = new Page(page,pageSize);
//
//        //构造条件构造器
//        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper();
//        //添加过滤条件
//        queryWrapper.like(StringUtils.isNotEmpty(name),Employee::getName,name);
//        //添加排序条件
//        queryWrapper.orderByDesc(Employee::getUpdateTime);
//
//        //执行查询
//        employeeService.page(pageInfo,queryWrapper);
//
//        return R.success(pageInfo);
//    }
//
//    @PostMapping("/login")
//    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {
////        String password = employee.getPassword();
////        String username = employee.getUsername();
//
//        R<Employee> result = employeeService.loginService(employee);
//        if (result.getCode()!=1){
//            return result;
//        }
//        Long id = result.getData().getId();
//        request.getSession().setAttribute("employee",id);
//        return result;
//    }
//    @PostMapping("/logout")
//    public R<String> logout(HttpServletRequest request){
//        request.getSession().removeAttribute("employee");
//        return R.success("logout successfully");
//    }
//
//
//
//    @PostMapping
//    public R<String> save(HttpServletRequest request,@RequestBody Employee employee){
//        Long id = (Long)request.getSession().getAttribute("employee");
//        employeeService.saveService(employee,id);
//        return R.success("Add successfully");
//    }
//
//    @GetMapping("/{id}")
//    public R<Employee> findById(@PathVariable Long id){
//        Employee result = employeeService.findById(id);
//        return R.success(result);
//    }
//
//    @PutMapping
//    public R<String> update(HttpServletRequest request,@RequestBody Employee employee){
//        Long updateUser=(Long) request.getSession().getAttribute("employee");
//        employee.setUpdateUser(updateUser);
//        employee.setUpdateTime(LocalDateTime.now());
//        R<String> result = employeeService.updateEmp(employee);
//        return result;
//
//
//    }
//
//
//
//}
//
//
//
//
////    @PutMapping
////    public R<String> update(HttpServletRequest request,@RequestBody Employee employee){
////        log.info(employee.toString());
////
////        Long empId = (Long)request.getSession().getAttribute("employee");
////        employee.setUpdateTime(LocalDateTime.now());
////        employee.setUpdateUser(empId);
////        employeeService.updateById(employee);
////
////        return R.success("员工信息修改成功");
////    }
//
//    /**
//     * 根据id查询员工信息
//     * @param id
//     * @return
//     */
////    @GetMapping("/{id}")
////    public R<Employee> getById(@PathVariable Long id){
////        log.info("根据id查询员工信息...");
////        Employee employee = employeeService.getById(id);
////        if(employee != null){
////            return R.success(employee);
////        }
////        return R.error("没有查询到对应员工信息");
////    }

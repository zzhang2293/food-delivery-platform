package com.fooddeliveryplatform.controller;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fooddeliveryplatform.domain.Employee;
import com.fooddeliveryplatform.result.Result;
import com.fooddeliveryplatform.service.EmployeeService;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * this method is used for employee login, it use PostMapping because the front will
     * send a json to it, post mapping is used to receive json request in rest style
     * @param request use to set a session for chrome
     * @param employee a json style string will convert to Employee when we receive that
     * @return response to front
     */
    @PostMapping("/login")
    public Result<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<Employee>();
        // same as writing a sql
        //get an emp by using username
        lambdaQueryWrapper.eq(Employee::getUsername, employee.getUsername());
        Employee emp = employeeService.getOne(lambdaQueryWrapper);
        // error condition
        if (emp == null) return Result.error("the user does not exist!!!");
        if (!password.equals(emp.getPassword())) {
            return Result.error("the username and password do not match!!!");
        }
        if (0 == emp.getStatus()) return Result.error("the account is banned !!!");

        request.getSession().setAttribute("employee", emp.getId());

        return Result.success(emp);
    }

    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("employee");
        return Result.success("logout successfully");

    }

    /**
     * add a new employee
     * @param employee a request from frontend
     * @return Result, give frontend some information
     */
    @PostMapping
    public Result<String> save(HttpServletRequest request, @RequestBody Employee employee){
        log.info("new employee, employee info: {}", employee.toString());
        // set original password, encoding with md5
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        employee.setUpdateTime(LocalDateTime.now());
        employee.setCreateTime(LocalDateTime.now());
        Long empId = (Long) request.getSession().getAttribute("employee");
        employee.setCreateUser(empId);
        employee.setUpdateUser(empId);
        employeeService.save(employee);

        return Result.success("new employee has been created");
    }

    /**
     * employee info pagination
     * @param page start page
     * @param pageSize total pages
     * @param name employee name
     * @return A page variable
     */
    @GetMapping("/page")
    public Result<Page<Employee>> page(int page,int pageSize,String name){
        log.info("page = {}, pageSize = {}, name = {}", page, pageSize, name);
        // pagination constructor
        Page<Employee> employeePage = new Page<>(page, pageSize);
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // add a filter condition
        lambdaQueryWrapper.like(StringUtils.isNotEmpty(name), Employee::getName, name);
        lambdaQueryWrapper.orderByDesc(Employee::getUpdateTime);
        employeeService.page(employeePage, lambdaQueryWrapper);
        System.out.println(employeePage.getTotal());
        return Result.success(employeePage);

    }
}

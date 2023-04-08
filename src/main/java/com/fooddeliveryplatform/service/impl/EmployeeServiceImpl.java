package com.fooddeliveryplatform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fooddeliveryplatform.domain.Employee;
import com.fooddeliveryplatform.mapper.EmployeeMapper;
import com.fooddeliveryplatform.result.Result;
import com.fooddeliveryplatform.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * this class is the implement of EmployeeService and provide several default Service function
 * if we use original method, we need to first autowired a dao called EmployeeMapper and then
 * use the function in EmployeeMapper, which is provided by us or provided by the extends class
 * called BaseMapper<Employee>
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
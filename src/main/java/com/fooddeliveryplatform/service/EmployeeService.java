package com.fooddeliveryplatform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fooddeliveryplatform.domain.Employee;
import org.springframework.stereotype.Service;

/**
 * this EmployeeService interface extends another interface,
 * but it has some default value
 */

public interface EmployeeService extends IService<Employee> {

}

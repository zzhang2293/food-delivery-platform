package com.fooddeliveryplatform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fooddeliveryplatform.domain.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * this class extends a base mapper, the base mapper can provide some basic sql operation
 * such as insert by id, delete, update by id, select all etc
 * another way to implement dao is using annotation, or use xml mapper and but that mapper into
 * the same directory.
 *
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {



}

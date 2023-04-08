package com.dailycodebuffer.employee.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.dailycodebuffer.employee.entity.EmployeeEntity;
import com.dailycodebuffer.employee.model.Employee;
import com.dailycodebuffer.employee.repository.EmployeeRepository;
import com.dailycodebuffer.employee.service.EmployeeService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author keer
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired private EmployeeRepository employeeRepository;

  @Override
  public Employee createEmployee(Employee employee) {
    EmployeeEntity employeeEntity = new EmployeeEntity();
    BeanUtil.copyProperties(employee, employeeEntity);
    employeeRepository.save(employeeEntity);
    return employee;
  }

  @Override
  public List<Employee> getAllEmployees() {
    List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
    return employeeEntities.stream()
        .map(
            item -> {
              Employee employee = new Employee();
              BeanUtil.copyProperties(item, employee);
              return employee;
            })
        .collect(Collectors.toList());
  }

  @Override
  public boolean deleteEmployee(Long id) {
    EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
    employeeRepository.delete(employeeEntity);
    return true;
  }

  @Override
  public Employee getEmployeeById(Long id) {
    EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
    Employee employee = new Employee();
    BeanUtil.copyProperties(employeeEntity, employee);
    return employee;
  }

  @Override
  public Employee updateEmployee(Employee employee) {
    EmployeeEntity employeeEntity = employeeRepository.findById(employee.getId()).get();

    BeanUtil.copyProperties(
        employee,
        employeeEntity,
        CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
    employeeRepository.save(employeeEntity);

    Employee newEmployee = new Employee();
    BeanUtil.copyProperties(employeeEntity, newEmployee);

    return newEmployee;
  }
}

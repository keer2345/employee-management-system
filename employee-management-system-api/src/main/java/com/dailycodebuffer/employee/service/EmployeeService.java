package com.dailycodebuffer.employee.service;

import com.dailycodebuffer.employee.model.Employee;
import java.util.List;
/**
 * @author keer
 */
public interface EmployeeService {
  /**
   * create employee
   *
   * @param employee
   * @return
   */
  Employee createEmployee(Employee employee);

  /**
   * get all employees
   *
   * @return
   */
  List<Employee> getAllEmployees();
  /**
   * delete employee
   *
   * @param id
   * @return
   */
  boolean deleteEmployee(Long id);
}

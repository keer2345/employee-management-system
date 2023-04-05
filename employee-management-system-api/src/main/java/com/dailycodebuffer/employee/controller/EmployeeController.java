package com.dailycodebuffer.employee.controller;

import com.dailycodebuffer.employee.model.Employee;
import com.dailycodebuffer.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;import java.util.List;

/**
 * Employee Controller
 *
 * @author keer
 */
@CrossOrigin(origins =  "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

  @Autowired private EmployeeService employeeService;

  @PostMapping
  public Employee createEmployee(@RequestBody Employee employee) {
    return employeeService.createEmployee(employee);
  }

  @GetMapping
  public List<Employee> getAllEmployees(){
    return employeeService.getAllEmployees();
  }
}

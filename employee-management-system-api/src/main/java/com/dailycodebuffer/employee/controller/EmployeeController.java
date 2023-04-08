package com.dailycodebuffer.employee.controller;

import com.dailycodebuffer.employee.model.Employee;
import com.dailycodebuffer.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Employee Controller
 *
 * @author keer
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

  @Autowired private EmployeeService employeeService;

  @PostMapping
  public Employee createEmployee(@RequestBody Employee employee) {
    return employeeService.createEmployee(employee);
  }

  @GetMapping
  public List<Employee> getAllEmployees() {
    return employeeService.getAllEmployees();
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
    boolean deleted = false;
    deleted = employeeService.deleteEmployee(id);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", deleted);
    return ResponseEntity.ok(response);
  }

  @GetMapping("{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
    Employee employee = employeeService.getEmployeeById(id);
    return ResponseEntity.ok(employee);
  }

  @PutMapping
  public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
    Employee newEmployee = employeeService.updateEmployee(employee);
    return ResponseEntity.ok(newEmployee);
  }
}

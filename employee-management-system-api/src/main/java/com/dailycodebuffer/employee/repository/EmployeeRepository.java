package com.dailycodebuffer.employee.repository;

import com.dailycodebuffer.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author keer
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {}

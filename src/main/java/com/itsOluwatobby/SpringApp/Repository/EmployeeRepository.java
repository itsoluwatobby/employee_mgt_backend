package com.itsOluwatobby.SpringApp.Repository;

import com.itsOluwatobby.SpringApp.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
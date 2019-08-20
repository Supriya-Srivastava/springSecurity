package com.example.securepp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.securepp.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}

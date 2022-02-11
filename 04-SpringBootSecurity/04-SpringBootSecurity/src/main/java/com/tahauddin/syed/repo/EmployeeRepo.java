package com.tahauddin.syed.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tahauddin.syed.domain.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}

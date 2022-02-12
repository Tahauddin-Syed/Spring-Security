package com.tahauddin.syed.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tahauddin.syed.domain.Employee;
import com.tahauddin.syed.repo.EmployeeRepo;

@Component
public class EmployeeDataRunner  implements CommandLineRunner{
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public void run(String... args) throws Exception {
		if(employeeRepo.count() == 0) {
			loadEmployeeData();
		}
	}

	private long loadEmployeeData() {
		employeeRepo.save(
				Employee.builder()
					.name("Steve")
					.salary(30000d)
					.build());
		
		employeeRepo.save(
				Employee.builder()
					.name("John")
					.salary(40000d)
					.build());
		
		employeeRepo.save(
				Employee.builder()
					.name("Mike")
					.salary(50000d)
					.build());
		
		employeeRepo.save(
				Employee.builder()
					.name("Jessica")
					.salary(60000d)
					.build());
		
		
		return employeeRepo.count();
	}
	
	

}

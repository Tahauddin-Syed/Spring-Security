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
					.name("Pondi")
					.salary(30000d)
					.build());
		
		employeeRepo.save(
				Employee.builder()
					.name("Aziz")
					.salary(40000d)
					.build());
		
		employeeRepo.save(
				Employee.builder()
					.name("Murli")
					.salary(50000d)
					.build());
		
		employeeRepo.save(
				Employee.builder()
					.name("Mohd Rafi")
					.salary(60000d)
					.build());
		
		
		return employeeRepo.count();
	}
	
	

}

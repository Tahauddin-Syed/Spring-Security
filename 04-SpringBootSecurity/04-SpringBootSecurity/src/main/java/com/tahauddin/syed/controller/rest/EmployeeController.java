package com.tahauddin.syed.controller.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tahauddin.syed.domain.Employee;
import com.tahauddin.syed.repo.EmployeeRepo;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepo empRepo;

	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee() {

		
		return new ResponseEntity<>(empRepo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id){
		
		Optional<Employee> optional = empRepo.findById(id);
		if(optional.isPresent()) {
			Employee employee = optional.get();
			return new ResponseEntity<>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
}

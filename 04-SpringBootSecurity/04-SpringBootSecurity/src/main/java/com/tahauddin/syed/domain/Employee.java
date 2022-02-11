package com.tahauddin.syed.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="EMPLOYEE_TABLE")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	
	private String name;
	
	private Double salary;

}

package com.basu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.basu.Adapter.EmployeeAdapter;
import com.basu.Entity.EmployeeEntity;
import com.basu.dto.DepartmentDto;
import com.basu.dto.EmpDeptDto;
import com.basu.dto.EmployeeDto;
import com.basu.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeAdapter adapter;
	
	@Autowired
	RestTemplate restTemplate;

	public EmployeeDto addEmployee(EmployeeEntity employeeEntity) {
		log.info("Started addEmployee method");
		EmployeeEntity employeeEntities = employeeRepository.save(employeeEntity);
		return adapter.getEmployeeDto(employeeEntities);
	}

	public List<EmployeeDto> getAllEmployee() {
		log.info("Insode getAllEmployee method");
		return adapter.getEmployeeDtos(employeeRepository.findAll());
	}

	public EmpDeptDto getEmpDeptDto(int empId) {
	    EmployeeEntity employeeEntity =	employeeRepository.findById(empId).get();
	    String url = "http://localhost:7002/api/Department/"+empId;
	    DepartmentDto departmentDto = restTemplate.getForObject(url, DepartmentDto.class);
	    
		return adapter.getEmpDeptDto(employeeEntity,departmentDto);
	}
}
package com.basu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basu.Entity.EmployeeEntity;
import com.basu.dto.EmpDeptDto;
import com.basu.dto.EmployeeDto;
import com.basu.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("api/Employee")
public class EmployeeServiceController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/AddEmployee")
	public EmployeeDto addEmployee(@RequestBody EmployeeEntity employeeEntity)
	{
		return employeeService.addEmployee(employeeEntity);
	}
	
	
	@GetMapping("/GetAllEmployee")
	public List<EmployeeDto> getAllEmployee()
	{
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/GetEmpDept/{id}")
	public EmpDeptDto getEmpDeptDto(@PathVariable("id") int empId)
	{
		return employeeService.getEmpDeptDto(empId);
	}
}

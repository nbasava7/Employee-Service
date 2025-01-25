package com.basu.Adapter;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.basu.Entity.EmployeeEntity;
import com.basu.dto.DepartmentDto;
import com.basu.dto.EmpDeptDto;
import com.basu.dto.EmployeeDto;

@Component
public class EmployeeAdapter {

	@Autowired
	ModelMapper mapper;

	public List<EmployeeDto> getEmployeeDtos(List<EmployeeEntity> employeeEntities) {

		return employeeEntities.stream().map(this::getEmployeeDto).toList();
	}

	public EmployeeDto getEmployeeDto(EmployeeEntity employeeEntity) {
		return mapper.map(employeeEntity, EmployeeDto.class);
	}
	
	public EmpDeptDto getEmpDeptDto(EmployeeEntity employeeEntity, DepartmentDto departmentDto)
	{
		EmpDeptDto empDeptDto = new EmpDeptDto();
		empDeptDto.setEmployeeDto(mapper.map(employeeEntity, EmployeeDto.class));
		empDeptDto.setDepartmentDto(departmentDto);
		return empDeptDto;
	}
}

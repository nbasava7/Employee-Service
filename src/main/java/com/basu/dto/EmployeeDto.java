package com.basu.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class EmployeeDto {
	private int id;
	private String name;
	private BigDecimal salary;
	private String address;
}

package com.basu.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EmployeeEntity {

	@Id
	private int id;
	private String name;
	private BigDecimal salary;
	private String address;
}

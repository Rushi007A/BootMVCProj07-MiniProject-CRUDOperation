package com.nit.service;

import com.nit.model.Employee;

public interface IEmployeeMgmtService {

	public Iterable<Employee> getAllEmployees();
	public String registerEmployee(Employee emp);
}

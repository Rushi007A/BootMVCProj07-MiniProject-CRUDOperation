package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.model.Employee;
import com.nit.repository.IEmployeeRepository;
@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepository empRepo;
	@Override
	public Iterable<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
		
	}
	@Override
	public String registerEmployee(Employee emp) {
		return "employee is saved with id value:"+empRepo.save(emp).getEmpno();
		
	}

}

package com.nit.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nit.model.Employee;
import com.nit.service.IEmployeeMgmtService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationController {
	@Autowired
	private IEmployeeMgmtService empService;

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/emp_report")
	public String showEmployeeReport(Map<String, Object> map) {
		System.out.println("EmployeeOperationController.showEmployeeReport()");
		Iterable<Employee> itEmps = empService.getAllEmployees();
		map.put("empsList", itEmps);
		return "show_employee_report";
	}

	@GetMapping("emp_add")
	public String showFromForsaveEmployee(@ModelAttribute("emp") Employee emp) {
		return "register_employee";
	}
	// add Employee opreration
	/*	
		@PostMapping("/emp_add")
		public String saveEmployee(@ModelAttribute("emp")Employee emp, Map<String,Object>map) {
			String msg=empService.registerEmployee(emp);
			Iterable <Employee> itEmps =empService.getAllEmployees();
			map.put("resultMsg", msg);
			map.put("empList", itEmps);
			
			return "show_employee_report";
		}*/

	// PRG Pattern code double posting duplicate form EX:1

	/*@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp")Employee emp, Map<String,Object>map) {
		System.out.println("EmployeeOperationController.saveEmployee()");
		Iterable<Employee> itEmps=empService.getAllEmployees();
		map.put("empList", itEmps);
		return "show_employee_report";
	}*/

	// EX:2 Best PRG Pattern

	/*	@PostMapping("/emp_add")
		public String saveEmployeeReport(Map<String,Object>map) {
			System.out.println("EmployeeOperationController.saveEmployeeReport()");
			Iterable<Employee>itEmps=empService.getAllEmployees();
			map.put("empList", itEmps);
			return "show_employee_report";
		}*/
	
	//EX:3 Using session obj and session attributes
	@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp")Employee emp,HttpSession ses) {
		System.out.println("EmployeeOperationController.saveEmployee()");
		String msg=empService.registerEmployee(emp);
		ses.setAttribute("resultMsg", msg);
		return "redirect:emp_report";
	}
		
}

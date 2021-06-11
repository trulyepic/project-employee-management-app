package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.entities.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@GetMapping("/empdir")
	public String directory(Model model) {
		
		List<Employee> employees = employeeRepo.findAll();
		model.addAttribute("employees", employees);
		return "employees/list-employees";
	}

	@GetMapping("/newEmp")
	public String employeeFormEntry(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("userEntry", employee);
		return "employees/employee-form";
	}
	
	
	@PostMapping("/save-form")
	public String saveEmployee(Model model, Employee employee) {
		employeeRepo.save(employee);
		
		return"redirect:/empdir";
	}
}

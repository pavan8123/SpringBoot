package com.pavan.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.database.model.Emoloyee;
import com.pavan.database.service.EmployeeService;

@RestController
@RequestMapping("api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employee")
	public ResponseEntity<Emoloyee> getEmployee(@PathVariable(value = "id") Integer id) {
		Emoloyee employee = employeeService.getEmployee(id);
		if (employee == null) {
			throw new NullPointerException(id + " not found exception");
		}
		return new ResponseEntity<Emoloyee>(employee, HttpStatus.OK);

	}

	@PostMapping("/employee")
	public ResponseEntity<Emoloyee> saveEmployee(@RequestBody Emoloyee employee) {
		Emoloyee empoyee = employeeService.saveEmployee(employee);
		return new ResponseEntity<Emoloyee>(employee, HttpStatus.OK);
	}

	@PutMapping("/employee")
	public ResponseEntity<Emoloyee> updateEmployee(@RequestBody Emoloyee employee) {
		Emoloyee empoyee = employeeService.updateEmployee(employee);
		return new ResponseEntity<Emoloyee>(employee, HttpStatus.OK);
	}

	@DeleteMapping("/employee")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id) {
		employeeService.delteEmployee(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}

}

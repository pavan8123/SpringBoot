package com.pavan.database.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.database.model.Emoloyee;
import com.pavan.database.model.Project;
import com.pavan.database.repository.EmployeeRepository;
import com.pavan.database.repository.ProjectRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ProjectRepository pr;

	@Transactional
	public Emoloyee saveEmployee(Emoloyee emp) {
		Project proj = new Project();
		proj.setName(emp.getProject().getName());
		if (!pr.existsByName(proj.getName()))
			pr.save(proj);
		return employeeRepository.save(emp);
	}

	public Emoloyee updateEmployee(Emoloyee emp) {
		Emoloyee empp = employeeRepository.findById(emp.getId()).get();
		empp.setId(emp.getId());
		empp.setName(emp.getName());
		return empp;
	}

	public void delteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}

	public Emoloyee getEmployee(Integer id) {
		return employeeRepository.findById(id).get();

	}

}

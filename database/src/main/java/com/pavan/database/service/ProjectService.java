package com.pavan.database.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.database.model.Emoloyee;
import com.pavan.database.model.Project;
import com.pavan.database.repository.EmployeeRepository;
import com.pavan.database.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public Project saveproloyee(Project pro) {
		Project p = new Project();
		p.setName(pro.getName());
		List<Emoloyee> employess = employeeRepository.findAll();
		List<Emoloyee> listEmployee = employess.stream().filter(x -> x.getProject().getName() == pro.getName())
				.collect(Collectors.toList());
		p.setEmployee(listEmployee);
		return projectRepository.save(p);
	}

	public Project updateproloyee(Project pro) {
		Project prop = projectRepository.findById(pro.getId()).get();
		prop.setId(pro.getId());
		prop.setName(pro.getName());
		prop.setEmployee(pro.getEmployee());
		return prop;
	}

	public void delteproloyee(Integer id) {
		projectRepository.deleteById(id);
	}

	public Project getproloyee(Integer id) {
		return projectRepository.findById(id).get();

	}

}

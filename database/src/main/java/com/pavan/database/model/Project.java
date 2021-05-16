package com.pavan.database.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Project_table")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name = "project_name")
	String name;
	@OneToMany(targetEntity = Emoloyee.class, cascade = CascadeType.ALL, mappedBy = "project")
	List<Emoloyee> employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Emoloyee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Emoloyee> employee) {
		this.employee = employee;
	}

	public Project(int id, String name, List<Emoloyee> employee) {
		super();
		this.id = id;
		this.name = name;
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", employee=" + employee + "]";
	}

	public Project() {
		super();
	}

}

package com.pavan.database.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Empoyee_Table_emp")
public class Emoloyee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "projectId")
	Project project;

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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Emoloyee(int id, String name, Project project) {
		super();
		this.id = id;
		this.name = name;
		this.project = project;
	}

	@Override
	public String toString() {
		return "Emoloyee [id=" + id + ", name=" + name + ", project=" + project + "]";
	}

	public Emoloyee() {
		super();
	}

}

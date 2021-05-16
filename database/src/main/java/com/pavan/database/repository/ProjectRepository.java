package com.pavan.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pavan.database.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

	List<String> findByName(String name);

	boolean existsByName(String name);

}

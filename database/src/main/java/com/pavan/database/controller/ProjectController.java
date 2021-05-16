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

import com.pavan.database.model.Project;
import com.pavan.database.service.ProjectService;

@RestController
@RequestMapping("api")
public class ProjectController {

	@Autowired
	ProjectService ProjectService;

	@GetMapping("/project")
	public ResponseEntity<Project> getProject(@PathVariable(value = "id") Integer id) {
		Project Project = ProjectService.getproloyee(id);
		if (Project == null) {
			throw new NullPointerException(id + " not found exception");
		}
		return new ResponseEntity<Project>(Project, HttpStatus.OK);

	}

	@PostMapping("/project")
	public ResponseEntity<Project> saveProject(@RequestBody Project Project) {
		Project project = ProjectService.saveproloyee(Project);
		return new ResponseEntity<Project>(Project, HttpStatus.OK);
	}

	@PutMapping("/Project")
	public ResponseEntity<Project> updateProject(@RequestBody Project Project) {
		Project project = ProjectService.updateproloyee(Project);
		return new ResponseEntity<Project>(Project, HttpStatus.OK);
	}

	@DeleteMapping("/Project")
	public ResponseEntity<String> deleteProject(@PathVariable("id") Integer id) {
		ProjectService.delteproloyee(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}

}

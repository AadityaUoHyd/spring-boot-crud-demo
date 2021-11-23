package org.aadi.springboot.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.aadi.springboot.demo.entity.Department;
import org.aadi.springboot.demo.error.DepartmentNotFoundException;
import org.aadi.springboot.demo.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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


@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping("/departments")
	public ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department) {

		LOGGER.info("Inside saveDepartment of DepartmentController");
		Department dept = departmentService.saveDepartment(department);
		HttpHeaders header = new HttpHeaders();
		header.add("Description","Creating new Department.");
		return ResponseEntity.status(HttpStatus.CREATED).headers(header).body(dept);
	}

	@GetMapping("/departments")
	public ResponseEntity<List<Department>> fetchDepartmentList() {

		LOGGER.info("Inside fetchDepartmentList of DepartmentController");
		List<Department> deptList = departmentService.fetchDepartmentList();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Description","Get list of all Department.");
		headers.add("Type of Objects", "Department object are fetched.");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(deptList);
	}

	@GetMapping("/departments/{id}")
	public ResponseEntity<Department> fetchDepartmentById(@PathVariable("id") Long departmentId)
			throws DepartmentNotFoundException {

		LOGGER.info("Inside fetchDepartmentById of DepartmentController");
		Department dept = departmentService.fetchDepartmentById(departmentId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Description","Get Department by Id.");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(dept);
	}

	@GetMapping("/departments/name/{name}")
	public ResponseEntity<Department> fetchDepartmentByName(@PathVariable("name") String departmentName) {

		LOGGER.info("Inside fetchDepartmentByName of DepartmentController");
		Department dept = departmentService.fetchDepartmentByName(departmentName);
		return ResponseEntity.ok(dept);
	}

	@PutMapping("/departments/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable("id") Long departmentId,
			@RequestBody Department department) {

		LOGGER.info("Inside updateDepartment of DepartmentController");
		Department dept = departmentService.updateDepartment(departmentId,department);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Description","Get Department by Id.");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(dept);
	}

	@DeleteMapping("/departments/{id}")
	public ResponseEntity<String> deleteDepartmentById(@PathVariable("id") Long departmentId) {

		LOGGER.info("Inside deleteDepartmentById of DepartmentController");
		departmentService.deleteDepartmentById(departmentId);
		String msg = "Department deleted Successfully!!";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Description","Deleted Department by Id.");
		return new ResponseEntity<String>(msg, headers, HttpStatus.NO_CONTENT); 
	}

}

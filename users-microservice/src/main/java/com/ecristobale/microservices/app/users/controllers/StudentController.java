package com.ecristobale.microservices.app.users.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecristobale.microservices.app.users.models.entity.Student;
import com.ecristobale.microservices.app.users.services.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<?> listStudents() {
		return ResponseEntity.ok().body(studentService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudent(@PathVariable Long id) {
		Optional<Student> oStudent = studentService.findById(id);
		if (oStudent.isEmpty()) {
			return ResponseEntity.notFound().build(); // return 404
		}
		return ResponseEntity.ok().body(oStudent.get());
	}
	
	@PostMapping
	public ResponseEntity<?> createStudent(@RequestBody Student student) {
		Student studentDB = studentService.save(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(studentDB); // return 201
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable Long id, 
			@RequestBody Student student) {
		Optional<Student> oStudent = studentService.findById(id);
		if (oStudent.isEmpty()) {
			return ResponseEntity.notFound().build(); // return 404
		}
		
		Student studentDB = oStudent.get();
		studentDB.setName(student.getName());
		studentDB.setSurname(student.getSurname());
		studentDB.setEmail(student.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentDB)); // return 201
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
		studentService.deleteById(id);
		return ResponseEntity.noContent().build(); // return 204
	}
	
}

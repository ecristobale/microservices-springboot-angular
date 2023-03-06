package com.ecristobale.microservices.app.students.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecristobale.microservices.app.students.models.entity.Student;
import com.ecristobale.microservices.app.students.services.StudentService;
import com.ecristobale.microservices.commons.controllers.CommonController;
import com.ecristobale.microservices.commons.services.CommonService;

@RestController
public class StudentController extends CommonController<Student, StudentService> {
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable Long id, 
			@RequestBody Student student) {
		Optional<Student> o = service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build(); // return 404
		}
		
		Student studentDB = o.get();
		studentDB.setName(student.getName());
		studentDB.setSurname(student.getSurname());
		studentDB.setEmail(student.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(studentDB)); // return 201
	}	
}

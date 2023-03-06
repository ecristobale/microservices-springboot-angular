package com.ecristobale.microservices.app.users.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecristobale.microservices.app.users.models.entity.Student;
import com.ecristobale.microservices.app.users.models.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Student> findById(Long id) {
		return studentRepository.findById(id);
	}

	@Override
	@Transactional
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		studentRepository.deleteById(id);
	}

}

package com.ecristobale.microservices.app.students.services;

import org.springframework.stereotype.Service;

import com.ecristobale.microservices.app.students.models.entity.Student;
import com.ecristobale.microservices.app.students.models.repository.StudentRepository;
import com.ecristobale.microservices.commons.services.CommonServiceImpl;

@Service
public class StudentServiceImpl extends CommonServiceImpl<Student, StudentRepository> implements StudentService {

}

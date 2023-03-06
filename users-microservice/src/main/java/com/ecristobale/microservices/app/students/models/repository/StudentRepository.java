package com.ecristobale.microservices.app.students.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecristobale.microservices.app.students.models.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

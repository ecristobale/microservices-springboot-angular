package com.ecristobale.microservices.app.users.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecristobale.microservices.app.users.models.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

package com.ecristobale.microservices.app.courses.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecristobale.microservices.app.courses.models.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}

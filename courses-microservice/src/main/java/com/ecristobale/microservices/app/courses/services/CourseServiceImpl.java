package com.ecristobale.microservices.app.courses.services;

import org.springframework.stereotype.Service;

import com.ecristobale.microservices.app.courses.models.entity.Course;
import com.ecristobale.microservices.app.courses.models.repository.CourseRepository;
import com.ecristobale.microservices.commons.services.CommonServiceImpl;

@Service
public class CourseServiceImpl extends CommonServiceImpl<Course, CourseRepository> implements CourseService {

}

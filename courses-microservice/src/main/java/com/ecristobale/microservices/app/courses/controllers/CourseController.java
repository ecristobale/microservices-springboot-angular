package com.ecristobale.microservices.app.courses.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecristobale.microservices.app.courses.models.entity.Course;
import com.ecristobale.microservices.app.courses.services.CourseService;
import com.ecristobale.microservices.commons.controllers.CommonController;

@RestController
public class CourseController extends CommonController<Course, CourseService> {

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable Long id) {
        Optional<Course> o = this.service.findById(id);
        if(!o.isPresent()) {  //o.isEmpty()
            return ResponseEntity.notFound().build(); // return 404
        }
        Course courseDB = o.get();
        courseDB.setName(course.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(courseDB)); // return 201
    }
}

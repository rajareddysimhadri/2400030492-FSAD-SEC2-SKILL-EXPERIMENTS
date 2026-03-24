package com.klu.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Course;
import com.klu.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService service;

    // Add Course
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {

        Course saved = service.addCourse(course);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // Get All Courses
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {

        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    // Get Course By ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable Integer id) {

        Course course = service.getCourseById(id);

        if(course == null)
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    // Update Course
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @RequestBody Course course) {

        Course updated = service.updateCourse(id, course);

        if(updated == null)
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // Delete Course
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) {

        boolean deleted = service.deleteCourse(id);

        if(!deleted)
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>("Course Deleted Successfully", HttpStatus.OK);
    }

    // Search by Title
    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> searchCourse(@PathVariable String title) {

        List<Course> courses = service.searchByTitle(title);

        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}
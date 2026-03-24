package com.klu.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Course;
import com.klu.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    CourseRepository repo;

    public Course addCourse(Course course) {
        return repo.save(course);
    }

    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    public Course getCourseById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public Course updateCourse(Integer id, Course course) {

        Course existing = repo.findById(id).orElse(null);

        if(existing != null) {
            existing.setTitle(course.getTitle());
            existing.setDuration(course.getDuration());
            existing.setFee(course.getFee());
            return repo.save(existing);
        }

        return null;
    }

    public boolean deleteCourse(Integer id) {

        Course course = repo.findById(id).orElse(null);

        if(course != null) {
            repo.delete(course);
            return true;
        }

        return false;
    }

    public List<Course> searchByTitle(String title) {
        return repo.findByTitle(title);
    }
}
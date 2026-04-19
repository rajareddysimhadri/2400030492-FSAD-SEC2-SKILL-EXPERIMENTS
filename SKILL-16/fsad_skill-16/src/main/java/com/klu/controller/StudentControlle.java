package com.klu.controller;

import com.klu.entity.Student;
import com.klu.repository.StudentRepository;
import com.klu.exception.StudentNotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentControlle {

    @Autowired
    private StudentRepository repo;

    @Operation(summary = "Add new student")
    @ApiResponse(responseCode = "200", description = "Student created")
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return repo.save(student);
    }

    @Operation(summary = "Get all students")
    @GetMapping
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Operation(summary = "Get student by ID")
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    @Operation(summary = "Update student")
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {

        Student existing = repo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));

        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setCourse(student.getCourse());

        return repo.save(existing);
    }

    @Operation(summary = "Delete student")
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        repo.deleteById(id);
        return "Student deleted successfully";
    }
}
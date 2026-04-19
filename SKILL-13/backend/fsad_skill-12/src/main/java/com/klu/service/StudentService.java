package com.klu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.Student;
import com.klu.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student addStudent(Student s) {
        return repository.save(s);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student updateStudent(Long id, Student s) {
        Student existing = repository.findById(id).orElseThrow();
        existing.setName(s.getName());
        existing.setEmail(s.getEmail());
        existing.setCourse(s.getCourse());
        return repository.save(existing);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
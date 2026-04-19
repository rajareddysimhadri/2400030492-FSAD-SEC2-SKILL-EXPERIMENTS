package com.klu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
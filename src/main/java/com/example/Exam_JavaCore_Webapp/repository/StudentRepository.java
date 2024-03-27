package com.example.Exam_JavaCore_Webapp.repository;

import com.example.Exam_JavaCore_Webapp.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}

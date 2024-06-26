package com.example.Exam_JavaCore_Webapp.service;

import com.example.Exam_JavaCore_Webapp.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    List<StudentEntity> findAll();
    List<StudentEntity> findByStudentName(String name);
    StudentEntity addAndEdit(StudentEntity entity);
    StudentEntity findId(int id);
    void delete(StudentEntity entity);

}

package com.example.Exam_JavaCore_Webapp.service.impl;

import com.example.Exam_JavaCore_Webapp.entity.StudentEntity;
import com.example.Exam_JavaCore_Webapp.repository.StudentRepository;
import com.example.Exam_JavaCore_Webapp.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<StudentEntity> findByStudentName(String name) {
        return studentRepository.findByStudentNameContaining(name);
    }

    @Override
    public StudentEntity addAndEdit(StudentEntity entity) {
        return studentRepository.save(entity);
    }

    @Override
    public StudentEntity findId(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(StudentEntity entity) {
        studentRepository.delete(entity);

    }
}

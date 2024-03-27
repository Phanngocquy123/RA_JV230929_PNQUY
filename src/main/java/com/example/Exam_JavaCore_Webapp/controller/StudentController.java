package com.example.Exam_JavaCore_Webapp.controller;

import com.example.Exam_JavaCore_Webapp.entity.StudentEntity;
import com.example.Exam_JavaCore_Webapp.entity.StudentRequest;
import com.example.Exam_JavaCore_Webapp.service.FileStorageService;
import com.example.Exam_JavaCore_Webapp.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/home")
public class StudentController {
    private StudentService studentService;
    private FileStorageService fileStorageService;
    private ModelMapper modelMapper;
    public StudentController(StudentService studentService, FileStorageService fileStorageService, ModelMapper modelMapper){
        this.studentService = studentService;
        this.fileStorageService = fileStorageService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/index")
    public String showListStudent(@RequestParam(name = "key", required = false) String key ,Model model){

        List<StudentEntity> studentList;
        if (key == null || key.isEmpty()){
            studentList = studentService.findAll();
        } else {
            studentList = studentService.findByStudentName(key);
        }
        model.addAttribute("students", studentList);
        model.addAttribute("key", key);
        return "/home/index";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("students", new StudentRequest());
        return "/home/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("students") StudentRequest student, Model model){
        student.setImageUrl(fileStorageService.upload(student.getImageReq()));
        StudentEntity studentEntity = modelMapper.map(student, StudentEntity.class);
        studentService.addAndEdit(studentEntity);
        return "redirect:/home/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model){
        StudentEntity studentEntity = studentService.findId(id);
        StudentRequest studentRequest = modelMapper.map(studentEntity, StudentRequest.class);
        model.addAttribute("students", studentRequest);
        return "/home/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, @ModelAttribute("students") StudentRequest studentRequest, Model model){
        if (!studentRequest.getImageUrl().isEmpty()){
            studentRequest.setImageUrl(fileStorageService.upload(studentRequest.getImageReq()));
        }
        StudentEntity entity = modelMapper.map(studentRequest, StudentEntity.class);
        studentService.addAndEdit(entity);
        return "redirect:/home/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        StudentEntity entity = studentService.findId(id);
        if (entity != null){
            studentService.delete(entity);
        }
        return "redirect:/home/index";
    }

}

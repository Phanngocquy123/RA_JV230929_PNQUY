package com.example.Exam_JavaCore_Webapp.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    String upload(MultipartFile file);

}

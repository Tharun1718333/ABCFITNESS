package com.example.springboot.Services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Models.Class.ClassDTO;
import com.example.springboot.Repositories.ClassRepository;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public void AddClass(ClassDTO classDTO) {
        if (classDTO.endDate.before(new Date())) {
            throw new IllegalArgumentException("End date cannot be in the past.");
        }
        classRepository.addClass(classDTO);
    }
}

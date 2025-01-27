package com.example.springboot.Controllers;

import com.example.springboot.Models.Class.ClassDTO;
import com.example.springboot.Services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping("/api/class/addClass")
    public ResponseEntity<String> addClass(@RequestBody ClassDTO classDTO) {
        try {
            classService.AddClass(classDTO);
            return new ResponseEntity<>("Class added successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Invalid data: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

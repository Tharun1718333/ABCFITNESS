package com.example.springboot.Models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Random;

public class Class {
    public int classId;
    public String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date endDate;

    public String startTime; // HH:mm format
    public int duration; // Duration in minutes
    public int capacity;

    public Class(int classId, String name, Date startDate, Date endDate, String startTime, int duration, int capacity) {
        this.classId = classId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.duration = duration;
        setCapacity(capacity); // Use setter to ensure validation
    }

    public Class() {
    }

    public void setCapacity(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be at least 1.");
        }
        this.capacity = capacity;
    }

    public static class ClassDTO {
        public String name;
        public Date startDate;
        public Date endDate;
        public String startTime;
        public int duration;
        public int capacity;

        public Class convertToClass(ClassDTO classDTO) {
            Random rand = new Random();
            int randomClassId = rand.nextInt(100000) + 1; // Generates a random booking ID between 1 and 100000
            return new Class(randomClassId, classDTO.name, classDTO.startDate, classDTO.endDate, classDTO.startTime,
                    classDTO.duration, classDTO.capacity);
        }
    }
}

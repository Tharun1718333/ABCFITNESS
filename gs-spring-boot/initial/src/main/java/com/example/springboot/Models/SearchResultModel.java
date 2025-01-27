package com.example.springboot.Models;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class SearchResultModel {
    public String className; // Class name
    public String startTime; // Class start time (HH:mm format)

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date bookingDate; // The date the booking was made

    public String memberName; // Member name who booked the class

    // Constructor to initialize all fields
    public SearchResultModel(String className, String startTime, Date bookingDate, String memberName) {
        this.className = className;
        this.startTime = startTime;
        this.bookingDate = bookingDate;
        this.memberName = memberName;
    }
}

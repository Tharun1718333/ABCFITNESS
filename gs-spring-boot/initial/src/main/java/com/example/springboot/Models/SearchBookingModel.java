package com.example.springboot.Models;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class SearchBookingModel {
    public Integer memberId; // Optional, filter by member ID

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date startDate; // Optional, start of date range

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date endDate; // Optional, end of date range
}

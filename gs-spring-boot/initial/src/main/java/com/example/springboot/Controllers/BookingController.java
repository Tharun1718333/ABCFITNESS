package com.example.springboot.Controllers;

import com.example.springboot.Models.Booking.BookingDTO;
import com.example.springboot.Models.SearchBookingModel;
import com.example.springboot.Models.SearchResultModel;
import com.example.springboot.Services.BookingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/add")
    public ResponseEntity<String> addBooking(@RequestBody BookingDTO bookingDTO) {
        bookingService.AddBooking(bookingDTO);
        return new ResponseEntity<>("Booking added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/search")
    public ResponseEntity<List<SearchResultModel>> searchBookings(@RequestBody SearchBookingModel searchTerms) {
        List<SearchResultModel> result = bookingService.SearchBookings(searchTerms);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

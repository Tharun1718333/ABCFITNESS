package com.example.springboot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Models.Booking.BookingDTO;
import com.example.springboot.Models.SearchBookingModel;
import com.example.springboot.Models.SearchResultModel;
import com.example.springboot.Repositories.BookingRepository;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public void AddBooking(BookingDTO booking) {
        bookingRepository.saveBooking(booking);
    }

    public List<SearchResultModel> SearchBookings(SearchBookingModel searchTerms) {
        return bookingRepository.searchBooking(searchTerms);
    }
}

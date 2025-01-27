package com.example.springboot.Models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Random;

public class Booking {
    public int bookingId;
    public int memberId; // Reference to Member by ID
    public int classId; // Reference to Class by ID

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date participationDate;

    public Booking(int bookingId, int memberId, int classId, Date participationDate) {
        this.bookingId = bookingId;
        this.memberId = memberId;
        this.classId = classId;
        this.participationDate = participationDate;
    }

    public Booking() {
    }

    public static class BookingDTO {
        public int memberId;
        public int classId;
        public Date participationDate;

        public Booking convertToBooking(BookingDTO bookingDTO) {
            Random rand = new Random();
            int randomBookingId = rand.nextInt(100000) + 1; // Generates a random booking ID between 1 and 1000
            return new Booking(randomBookingId, bookingDTO.memberId, bookingDTO.classId,
                    bookingDTO.participationDate);
        }
    }
}

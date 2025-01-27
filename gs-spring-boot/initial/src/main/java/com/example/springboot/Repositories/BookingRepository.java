package com.example.springboot.Repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.example.springboot.Models.Class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboot.Models.Booking;
import com.example.springboot.Models.SearchBookingModel;
import com.example.springboot.Models.SearchResultModel;
import com.example.springboot.Models.Booking.BookingDTO;

@Repository
public class BookingRepository extends BaseRepository<Booking> {
    private static String FILE_PATH = "DatabaseFiles/Bookings.json";
    @Autowired
    private ClassRepository classRepository;

    public void saveBooking(BookingDTO booking) {
        List<Class> classes = classRepository.readData(ClassRepository.FILE_PATH, Class.class);
        Class SelectedClass = classes.stream().filter(c -> c.classId == booking.classId).findFirst().orElse(null);
        if (SelectedClass == null) {
            throw new IllegalArgumentException("Class not found");
        }
        if (SelectedClass.capacity <= 0) {
            throw new IllegalArgumentException("Class is full");
        }
        if ((!booking.participationDate.after(new Date())) || (!booking.participationDate.after(SelectedClass.endDate))
                || (!booking.participationDate.before(SelectedClass.startDate))) {
            throw new IllegalArgumentException("Date is invalid");
        }
        SelectedClass.capacity--;
        classRepository.writeData(ClassRepository.FILE_PATH, classes);
        List<Booking> bookings = readData(FILE_PATH, Booking.class);
        bookings.add(booking.convertToBooking(booking));
        System.err.println(bookings);
        writeData(FILE_PATH, bookings);
    }

    public List<SearchResultModel> searchBooking(SearchBookingModel searchTerms) {
        List<Booking> bookings = readData(FILE_PATH, Booking.class);
        List<Booking> filteredBookings = new ArrayList<>();
        for (Booking booking : bookings) {
            if (((searchTerms.memberId == null) || (booking.memberId == searchTerms.memberId))
                    && ((searchTerms.startDate == null) || (!searchTerms.startDate.after(booking.participationDate)))
                    && ((searchTerms.endDate == null) || (!searchTerms.endDate.before(booking.participationDate)))) {
                filteredBookings.add(booking);
            }
        }
        List<SearchResultModel> results = new ArrayList<>();
        for (Booking booking : filteredBookings) {
            Class classObj = new ClassRepository().GetClassById(booking.classId);
            results.add(new SearchResultModel(classObj.name, classObj.startTime, booking.participationDate,
                    new MemberRepository().GetMemberById(booking.memberId).memberName));
        }
        return results;
    }
}

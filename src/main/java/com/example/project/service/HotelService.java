package com.example.project.service;

import com.example.project.dto.BookingDTO;
import com.example.project.entity.Booking;
import com.example.project.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class HotelService {

    private final BookingsRepository repository;

    @Autowired
    public HotelService(BookingsRepository repository) {
        this.repository = repository;
    }

    public List<BookingDTO> getAllBookings() {
        return repository
                .findAll()
                .stream()
                .map(booking -> booking.mapTo(booking))
                .collect(Collectors.toList());
    }

    public Boolean addBooking(BookingDTO bookingDTO) {
        try {
            repository.save(bookingDTO.mapTo(bookingDTO));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean updateBooking(Long id, String newEmail) {
        Booking existingBooking = repository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
        existingBooking.setEmail(newEmail);
        try {
            repository.save(existingBooking);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean deleteBooking(Long id) {
        repository.deleteById(id);
        return true;
    }
}

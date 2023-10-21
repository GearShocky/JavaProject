package com.example.project.controller;

import com.example.project.dto.BookingDTO;
import com.example.project.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/gears/hotel")
public class HotelController {

    private final HotelService service;

    @Autowired
    public HotelController(HotelService service) {
        this.service = service;
    }

    @GetMapping
    public List<BookingDTO> getAllBookings() {
        return service.getAllBookings();
    }

    @PostMapping
    public Boolean addBooking(@RequestBody BookingDTO bookingDTO) {
        return service.addBooking(bookingDTO);
    }

    @PutMapping("/{id}")
    public Boolean updateBooking(
            @PathVariable Long id,
            @RequestParam String email
    ) {
        return service.updateBooking(id, email);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteBooking(@PathVariable Long id) {
        return service.deleteBooking(id);
    }
}

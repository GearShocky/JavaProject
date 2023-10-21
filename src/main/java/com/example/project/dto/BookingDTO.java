package com.example.project.dto;

import com.example.project.entity.Booking;
import com.example.project.base.MapTo;
import lombok.Getter;

import java.util.Objects;

@Getter
public class BookingDTO implements MapTo<Booking, BookingDTO> {
    private final Long id;
    private String firstname;
    private String lastname;
    private String email;

    public BookingDTO(Long id, String firstname, String lastname, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    @Override
    public Booking mapTo(BookingDTO bookingDTO) {
        return new Booking(
                firstname = bookingDTO.getFirstname(),
                lastname = bookingDTO.getLastname(),
                email = bookingDTO.getEmail()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingDTO bookingDTO = (BookingDTO) o;
        return Objects.equals(id, bookingDTO.id) && Objects.equals(firstname, bookingDTO.firstname) && Objects.equals(lastname, bookingDTO.lastname) && Objects.equals(email, bookingDTO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, email);
    }
}

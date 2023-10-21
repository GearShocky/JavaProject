package com.example.project.entity;

import com.example.project.dto.BookingDTO;
import com.example.project.base.MapTo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name = "bookings")
@NoArgsConstructor
public class Booking implements MapTo<BookingDTO, Booking> {
    @Id
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    @Setter
    private String email;

    public Booking(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    @Override
    public BookingDTO mapTo(Booking booking) {
        return new BookingDTO(
                id = booking.getId(),
                firstname = booking.getFirstname(),
                lastname = booking.getLastname(),
                email = booking.getEmail()
        );
    }
}

package com.example.project.repository;

import com.example.project.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingsRepository extends JpaRepository<Booking, Long> { }
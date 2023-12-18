package com.example.Hotel.Hotel.Repo;

import com.example.Hotel.Hotel.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel,String> {
}

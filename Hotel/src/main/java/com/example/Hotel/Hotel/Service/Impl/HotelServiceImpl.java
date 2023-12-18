package com.example.Hotel.Hotel.Service.Impl;

import com.example.Hotel.Hotel.exceptions.ResourceNotFoundException;
import com.example.Hotel.Hotel.Entity.Hotel;
import com.example.Hotel.Hotel.Repo.HotelRepo;
import com.example.Hotel.Hotel.Service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepo hotelRepo;
    @Override
    public List<Hotel> getALlHotel() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel addHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepo.save(hotel);
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No hotel found with given id"));
    }
}

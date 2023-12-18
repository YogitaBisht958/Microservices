package com.example.Hotel.Hotel.Service;

import com.example.Hotel.Hotel.Entity.Hotel;

import java.util.List;

public interface HotelService {

    public List<Hotel> getALlHotel();
    public Hotel addHotel(Hotel hotel);

    public Hotel getHotel(String id);
}

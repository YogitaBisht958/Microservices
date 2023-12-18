package com.example.RatingService.Repo;

//import com.example.Hotel.Hotel.Entity.Hotel;
import com.example.RatingService.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepo extends JpaRepository<Rating,String> {
    // custom finder method
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}

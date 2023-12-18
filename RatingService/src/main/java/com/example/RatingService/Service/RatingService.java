package com.example.RatingService.Service;

//import com.example.Hotel.Hotel.Entity.Hotel;
import com.example.RatingService.Entity.Rating;

import java.util.List;

public interface RatingService {
    //create rating
    public Rating addRating(Rating rating);

    // get all ratings
    public List<Rating> getALlRatings();

    // get All by UserId
    public List<Rating> getRatingByUserId(String userId);

    // get All by hotelId
    public  List<Rating> getRatingByHotelId(String hotelId);
}

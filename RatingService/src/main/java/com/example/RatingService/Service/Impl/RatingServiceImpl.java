package com.example.RatingService.Service.Impl;

import com.example.RatingService.Entity.Rating;
import com.example.RatingService.Repo.RatingRepo;
import com.example.RatingService.Service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepo ratingRepo;
    @Override
    public Rating addRating(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getALlRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
       return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }
}

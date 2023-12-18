package com.cfg.user.service.entities;

import com.cfg.user.service.entities.Enums.Ratings;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
//    private String userId;
//    private String hotelId;
//
//    @Enumerated(EnumType.STRING)
//    private Ratings rating;

    private String id;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

    private Hotel hotel;
}

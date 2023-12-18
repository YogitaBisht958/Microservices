package com.cfg.user.service.services.impl;

import com.cfg.user.service.entities.Hotel;
import com.cfg.user.service.entities.Rating;
import com.cfg.user.service.exceptions.ResourceNotFoundException;
import com.cfg.user.service.external.services.HotelService;
import com.cfg.user.service.repositories.userRepository;
import com.cfg.user.service.services.userService;
import com.cfg.user.service.entities.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements userService {
    @Autowired
    private userRepository userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        // implement rating service call using rest template
        List<User> users = userRepo.findAll();
//        users.forEach(user -> {
//            // fetch ratings given by above user with the help of RATING service
////        http://localhost:8083/rating/users/e1d6e7ce-6a0d-4bc2-a18a-d1074263dc58
//            Rating[] ratingsOfUser  = restTemplate.getForObject("http://localhost:8083/rating/users/"+user.getUserId(), Rating[].class);
//            assert ratingsOfUser != null;
//            logger.info("{} " + ratingsOfUser.toString());
//
//            List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
//
//            List<Rating> ratingList = ratings.stream().map(rating -> {
//                // api call to hotel service to get the hotel
////            http://localhost:8082/hotel/928828af-45dd-4730-a98e-f4a313911256
//                ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8082/hotel/"+rating.getHotelId(), Hotel.class);
//                Hotel hotel = forEntity.getBody();
//                logger.info("response status code : " + forEntity.getStatusCode());
//
//                // set hotel to the rating
//                rating.setHotel(hotel);
//
//                //return the rating
//                return rating;
//            }).collect(Collectors.toList());
//
//            user.setRatings((ArrayList<Rating>) ratingList);
//        });

        return users;
    }

    @Override
    public User getUser(String userId) {
        // get user by userId with the help of UserRepository
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user with given id is" +
                        " not found on server !! " + userId));

//        // fetch ratings given by above user with the help of RATING service using REST TEMPLATES
////        http://localhost:8083/rating/users/e1d6e7ce-6a0d-4bc2-a18a-d1074263dc58
//        Rating[] ratingsOfUser  = restTemplate.getForObject("http://RATING/rating/users/"+user.getUserId(), Rating[].class);
//        assert ratingsOfUser != null;
//        logger.info("{} " + ratingsOfUser.toString());
//
//        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
//
//        List<Rating> ratingList = ratings.stream().map(rating -> {
//            // api call to hotel service to get the hotel
////            http://localhost:8082/hotel/928828af-45dd-4730-a98e-f4a313911256
//             ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL/hotel/"+rating.getHotelId(), Hotel.class);
//             Hotel hotel = forEntity.getBody();
//             logger.info("response status code : " + forEntity.getStatusCode());

        // fetch ratings given by above user with the help of RATING service using "FEIGN CLIENT"
//        http://localhost:8083/rating/users/e1d6e7ce-6a0d-4bc2-a18a-d1074263dc58
        Rating[] ratingsOfUser  = restTemplate.getForObject("http://RATING/rating/users/"+user.getUserId(), Rating[].class);
        assert ratingsOfUser != null;
        logger.info("{} " + ratingsOfUser.toString());

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            // api call to hotel service to get the hotel
//            http://localhost:8082/hotel/928828af-45dd-4730-a98e-f4a313911256
            Hotel hotel = hotelService.getHotel(rating.getHotelId());

            // set hotel to the rating
            rating.setHotel(hotel);

            //return the rating
            return rating;
        }).collect(Collectors.toList());

        user.setRatings((ArrayList<Rating>) ratingList);
        return user;
    }
}

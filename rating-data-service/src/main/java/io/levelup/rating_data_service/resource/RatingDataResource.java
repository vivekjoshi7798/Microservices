package io.levelup.rating_data_service.resource;

import io.levelup.rating_data_service.model.Rating;
import io.levelup.rating_data_service.model.UserRating;
import io.levelup.rating_data_service.services.RatingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataResource {

    @Autowired
    RatingDataService ratingDataService;
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return  ratingDataService.getRating(movieId);
    }

    @RequestMapping("user/{user_id}")
    public UserRating getRatingBasedOnUserid(@PathVariable("user_id") String userid){
        List<Rating>  userRatingList = ratingDataService.getAllRatings();
        UserRating userRating=  new UserRating();
        userRating.setRatings(userRatingList);
        userRating.setUserId(userid);
        return userRating;

    }


}

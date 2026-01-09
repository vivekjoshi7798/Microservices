package io.levelup.rating_data_service.services;

import io.levelup.rating_data_service.dao.RatingDao;
import io.levelup.rating_data_service.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingDataServiceImpl implements RatingDataService {

    @Autowired
    RatingDao ratingDao;


    @Override
    public Rating getRating(String movieId) {
        Optional<Rating> rating = ratingDao.findAll().stream().reduce((rating1, rating2) -> {
            if(rating1.getMovieId().equals(movieId)){
                return rating1;
            } else if (rating2.getMovieId().equals(movieId)) {
                return rating2;
            } else{
                return null;
            }
        });
        return rating.orElse(null);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingDao.findAll();
    }

}

package io.levelup.rating_data_service.services;

import io.levelup.rating_data_service.model.Rating;

import java.util.List;

public interface RatingDataService {

    Rating getRating(String movieId);
    List<Rating> getAllRatings();
}

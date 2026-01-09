package io.levelup.movie_info_service.services;


import io.levelup.movie_info_service.model.Movie;

import java.util.List;

public interface MovieServices {

    Movie getMovie(String movieId);
    List<Movie> getAllMovie();
}

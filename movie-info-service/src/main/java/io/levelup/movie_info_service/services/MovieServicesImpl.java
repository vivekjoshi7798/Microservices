package io.levelup.movie_info_service.services;

import io.levelup.movie_info_service.dao.MovieDao;
import io.levelup.movie_info_service.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServicesImpl implements MovieServices{
    @Autowired
    MovieDao movieDao;
    @Override
    public Movie getMovie(String movieId) {
        Optional<Movie> movies= movieDao.findAll().stream().filter(movie -> movie.getMovieId().equals(movieId)).findFirst();
        return movies.orElse(null);
    }

    @Override
    public List<Movie> getAllMovie() {
        return movieDao.findAll();
    }
}

package io.levelup.movie_info_service.dao;

import io.levelup.movie_info_service.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDao extends JpaRepository<Movie,String> {
}

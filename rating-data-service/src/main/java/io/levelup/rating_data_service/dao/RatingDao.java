package io.levelup.rating_data_service.dao;

import io.levelup.rating_data_service.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingDao  extends JpaRepository<Rating,Integer> {
}

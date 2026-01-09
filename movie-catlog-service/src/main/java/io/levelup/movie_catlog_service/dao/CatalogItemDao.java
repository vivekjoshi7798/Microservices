package io.levelup.movie_catlog_service.dao;

import io.levelup.movie_catlog_service.models.CatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogItemDao  extends JpaRepository<CatalogItem,Integer> {

}

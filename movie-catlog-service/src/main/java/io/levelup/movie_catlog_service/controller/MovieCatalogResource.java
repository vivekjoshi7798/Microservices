package io.levelup.movie_catlog_service.controller;

import io.levelup.movie_catlog_service.models.CatalogItem;
import io.levelup.movie_catlog_service.models.Movie;
import io.levelup.movie_catlog_service.models.Rating;
import io.levelup.movie_catlog_service.models.UserRating;
import io.levelup.movie_catlog_service.service.CatalogItemService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    private static final Logger logger = LoggerFactory.getLogger(MovieCatalogResource.class);

    @Autowired
    RestTemplate restTemplate ;
    @Autowired
    CatalogItemService catalogItemService;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") int userId) {
        UserRating ratings=restTemplate.getForObject("http://rating-data-service/ratingsdata/user/"+userId, UserRating.class);
        return ratings.getRatings().stream().map(rating ->{

        Movie m=restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
        if(Objects.isNull(m)){
            logger.info("Movie not found for Movie ID [{}]", m);
        }
        return catalogItemService.getAllCatalogItem().getFirst();
       }).collect(Collectors.toList());


    }
    @PostMapping(value = "addCatalogItem")
    public List<CatalogItem> addCatalogItem(@RequestBody CatalogItem catalogItem){



        logger.info("return response for {}",catalogItem);
        catalogItemService.addCatalogItem(catalogItem);
        return Collections.singletonList(catalogItem);
    }

}

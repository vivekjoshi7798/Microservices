package io.levelup.movie_info_service.resources;



import io.levelup.movie_info_service.model.Movie;
import io.levelup.movie_info_service.services.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MovieServices movieServices;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        return movieServices.getMovie(movieId);

    }

    @RequestMapping("/all")
    public List<Movie> getAllMovieInfo() {
    return movieServices.getAllMovie();

    }

     public void getMoivesFromOut(){
      Movie m= restTemplate.getForObject("https://freetestapi.com/api/v1/movies/1", Movie.class);
         System.out.println(m);
     }
}
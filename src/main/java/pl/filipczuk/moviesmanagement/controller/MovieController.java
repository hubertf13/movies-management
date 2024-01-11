package pl.filipczuk.moviesmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.filipczuk.moviesmanagement.model.Movie;
import pl.filipczuk.moviesmanagement.service.MovieService;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/search")
    public ResponseEntity<Movie> searchMovies(@RequestParam String title) {
        Optional<Movie> movie = movieService.searchMovie(title);

        return movie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

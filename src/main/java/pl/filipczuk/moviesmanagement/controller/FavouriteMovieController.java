package pl.filipczuk.moviesmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.filipczuk.moviesmanagement.exception.MovieNotFoundException;
import pl.filipczuk.moviesmanagement.model.FavouriteMovie;
import pl.filipczuk.moviesmanagement.service.FavouriteMovieService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/favourite-movies")
public class FavouriteMovieController {
    private final FavouriteMovieService favouriteMovieService;

    @PostMapping("/add")
    public ResponseEntity<FavouriteMovie> addFavouriteMovie(@RequestBody FavouriteMovie favouriteMovie) {
        try {
            return ResponseEntity.ok(favouriteMovieService.addFavouriteMovie(favouriteMovie));
        } catch (MovieNotFoundException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/add/{imdbID}")
    public ResponseEntity<FavouriteMovie> addFavouriteMovie(@PathVariable String imdbID) {
        try {
            return ResponseEntity.ok(favouriteMovieService.addFavouriteMovie(imdbID));
        } catch (MovieNotFoundException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<FavouriteMovie>> getAllFavouriteMovies() {
        try {
            return ResponseEntity.ok(favouriteMovieService.getAllFavouriteMovies());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}

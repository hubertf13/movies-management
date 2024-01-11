package pl.filipczuk.moviesmanagement.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.filipczuk.moviesmanagement.MoviesManagementApplication;
import pl.filipczuk.moviesmanagement.exception.MovieNotFoundException;
import pl.filipczuk.moviesmanagement.model.FavouriteMovie;
import pl.filipczuk.moviesmanagement.repository.FavouriteMovieRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class FavouriteMovieService {
    private final FavouriteMovieRepository favouriteMovieRepository;

    public FavouriteMovie addFavouriteMovie(FavouriteMovie favouriteMovie) {
        Optional<FavouriteMovie> favouriteMovieFromDatabase = favouriteMovieRepository.findByImdbID(favouriteMovie.getImdbID());
        return favouriteMovieFromDatabase.orElseGet(() -> favouriteMovieRepository.save(favouriteMovie));
    }

    public FavouriteMovie addFavouriteMovie(String imdbID) {
        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(MoviesManagementApplication.OMDBAPIURL)
                .queryParam("apikey", MoviesManagementApplication.OMDBAPIKEY)
                .queryParam("i", imdbID);

        FavouriteMovie favouriteMovie = restTemplate.getForObject(uriBuilder.toUriString(), FavouriteMovie.class);

        if (favouriteMovie != null && "True".equalsIgnoreCase(favouriteMovie.getResponse())) {
            Optional<FavouriteMovie> favouriteMovieFromDatabase = favouriteMovieRepository.findByImdbID(favouriteMovie.getImdbID());
            return favouriteMovieFromDatabase.orElseGet(() -> favouriteMovieRepository.save(favouriteMovie));
        } else {
            throw new MovieNotFoundException(imdbID);
        }
    }

    public List<FavouriteMovie> getAllFavouriteMovies() {
        return favouriteMovieRepository.findAll();
    }
}

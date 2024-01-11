package pl.filipczuk.moviesmanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.filipczuk.moviesmanagement.MoviesManagementApplication;
import pl.filipczuk.moviesmanagement.model.Movie;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MovieService {
    public Optional<Movie> searchMovie(String title) {
        String formattedTitle = formatTitleForQuery(title);

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(MoviesManagementApplication.OMDBAPIURL)
                .queryParam("apikey", MoviesManagementApplication.OMDBAPIKEY)
                .queryParam("t", formattedTitle);

        Movie movie = restTemplate.getForObject(uriBuilder.toUriString(), Movie.class);

        if (movie != null && "True".equalsIgnoreCase(movie.getResponse()))
            return Optional.of(movie);
        else
            return Optional.empty();
    }

    private String formatTitleForQuery(String title) {
        return title.replaceAll(" ", "+");
    }
}

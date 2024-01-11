package pl.filipczuk.moviesmanagement.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String imdbID) {
        super("Movie not found for IMDB ID: " + imdbID);
    }
}

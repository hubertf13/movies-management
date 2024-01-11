package pl.filipczuk.moviesmanagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
public class Movie {

    protected String imdbID;
    @JsonProperty("Title")
    protected String title;
    @JsonProperty("Genre")
    protected String genre;
    @JsonProperty("Director")
    protected String director;
    @JsonProperty("Plot")
    protected String plot;
    @JsonProperty("Poster")
    protected String poster;
    @JsonProperty("Response")
    private String response;
}

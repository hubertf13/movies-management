package pl.filipczuk.moviesmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class FavouriteMovie extends Movie {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
}
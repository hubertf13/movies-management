package pl.filipczuk.moviesmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.filipczuk.moviesmanagement.model.FavouriteMovie;

import java.util.Optional;

@Repository
public interface FavouriteMovieRepository extends JpaRepository<FavouriteMovie, Long> {
    Optional<FavouriteMovie> findByImdbID(String imdbID);
}

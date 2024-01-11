package pl.filipczuk.moviesmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviesManagementApplication {
    public final static String OMDBAPIURL = "https://www.omdbapi.com/";
    public final static String OMDBAPIKEY = "6a503c20";

    public static void main(String[] args) {
        SpringApplication.run(MoviesManagementApplication.class, args);
    }
}

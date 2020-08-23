package lv.sdacademy.app;

import lv.sdacademy.app.domain.Movie;
import lv.sdacademy.app.repository.MovieRepository;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        MovieRepository movieRepository = new MovieRepository();
        movieRepository.findById(1);

        System.out.println("\n\n------ List all movies.---------");
        List<Movie> allMovies = movieRepository.findAll();

        allMovies.forEach(movie -> {
            System.out.println(movie);
        });
    }
}

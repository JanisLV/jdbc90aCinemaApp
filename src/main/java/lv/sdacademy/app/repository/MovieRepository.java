package lv.sdacademy.app.repository;

import lv.sdacademy.app.domain.Movie;

import java.util.List;

public class MovieRepository extends AbstractHibernateRepository<Movie, Integer> {
    public List<Movie> findAll() {
        return findAll(Movie.class);
    }

    public Movie findById(Integer id) {
        return findById(Movie.class, id);
    }
}

package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private Movie[] movies = new Movie[0];
    private int count;
    private int movieCount = 10;
    private AfishaRepository repository;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public void setMovieCount(int movieCount) {
        this.movieCount = movieCount;
    }

    public void add(Movie movie) {
        repository.save(movie);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Movie[] getAll() {
        Movie[] movies = repository.findAll();
        Movie[] result = new Movie[movies.length];
        if (count == 0 && movies.length <= movieCount) {
            result = new Movie[movies.length];
        }
        if (count == 0 && movies.length >= movieCount++) {
            result = new Movie[10];
        }
        if (count != 0 && movies.length >= count) {
            result = new Movie[count];
        }
        if (count != 0 && movies.length < count) {
            result = new Movie[movies.length];
        }
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public void removeAll() {
        repository.removeAll();
    }

    public Movie[] findById(int id) {
        return repository.findById(id);
    }

}

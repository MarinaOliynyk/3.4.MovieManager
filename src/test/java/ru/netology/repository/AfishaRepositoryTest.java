
package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    Movie first = new Movie(1, "https://Bloodshot_poster.jpg", "Bloodshot", "action");
    Movie second = new Movie(2, "https://Onward_poster.jpg", "Onward", "animated");
    Movie third = new Movie(3, "https://hotel_belgrade_poster.jpg", "Hotel_belgrade", "comedy");
    Movie fourth = new Movie(4, "https://The_Gentlemen_poster.jpg", "The_Gentlemen", "action");


    @BeforeEach
    public void setUp(){
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
    }

    @Test
    void shouldSave() {
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second ,third,fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 2;
        repository.removeById(idToRemove);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, third, fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        repository.findAll();
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        int idToFind = 3;
        Movie[] actual = repository.findById(idToFind);
        Movie[] expected = new Movie[]{third};
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldNotFindById() {
        int idToFind = 5;
        Movie[] actual = repository.findById(idToFind);
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }
}
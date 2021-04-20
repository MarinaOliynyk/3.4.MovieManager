package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    MovieManager manager = new MovieManager();
    Movie first = new Movie(1, "https://Bloodshot_poster.jpg", "Bloodshot", "action");
    Movie second = new Movie(2, "https://Onward_poster.jpg", "Onward", "animated");
    Movie third = new Movie(3, "https://hotel_belgrade_poster.jpg", "Hotel_belgrade", "comedy");
    Movie fourth = new Movie(4, "https://The_Gentlemen_poster.jpg", "The_Gentlemen", "action");
    Movie fifth = new Movie(5, "https://The_Invisible_Man_poster.jpg", "The_Invisible_Man", "thriller");
    Movie sixth = new Movie(6, "https://Trolls_World_Tour_poster.jpg", "Trolls_World_Tour", "animated");
    Movie seventh = new Movie(7, "https://Number_One_poster.jpg", "Number_One", "comedy");
    Movie eighth = new Movie(8, "https://Wrath_of_Man_poster.jpg", "Wrath_of_Man", "action");
    Movie ninth = new Movie(9, "https://Mad_Max_poster.jpg", "Mad_Max", "action");
    Movie tenth = new Movie(10, "https://Soul_poster.jpg", "Soul", "animated");
    Movie eleven = new Movie(11, "https://Knives_Out_poster.jpg", "Knives_Out", "detective");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
    }

    @Test
    void addMovie() {
        Movie eleven = new Movie(11, "https://Knives_Out_poster.jpg", "Knives_Out", "detective");
        manager.add(eleven);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{eleven, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldLastMovies() {
        MovieManager manager = new MovieManager();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldMovieLessLimit() {
        MovieManager manager = new MovieManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMoviesLessTen() {
        MovieManager manager = new MovieManager(8);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        Movie[] actual = manager.getMovies();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMoviesOverLimit() {
        MovieManager manager = new MovieManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleven);
        Movie[] actual = manager.getMovies();
        Movie[] expected = new Movie[]{eleven, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMoviesLimit() {
        MovieManager manager = new MovieManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        Movie[] actual = manager.getMovies();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
}
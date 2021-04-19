package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)

class AfishaManagerTest {
    @Mock
    AfishaRepository repository;

    @InjectMocks
    AfishaManager manager;

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

    @Test
    void add10Movie() {
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void addMoreMovie() {
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleven};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{eleven, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();

    }

    @Test
    void shouldRemoveAll() {
        Movie[] returned = new Movie[0];
        doReturn(returned).when(repository).findAll();
        manager.removeAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
        verify(repository).removeAll();
        verify(repository).findAll();
    }

    @Test
    void shouldFindById() {
        int idFind = 4;
        Movie[] returned = new Movie[]{fourth};
        doReturn(returned).when(repository).findById(idFind);
        Movie[] actual = manager.findById(idFind);
        Movie[] expected = new Movie[]{fourth};
        assertArrayEquals(expected, actual);
        verify(repository).findById(idFind);
    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 4;
        Movie[] returned = new Movie[]{first, second, third, fifth};
        doReturn(returned).when(repository).findAll();
        manager.removeById(idToRemove);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fifth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }

    @Test
    void addMovie() {
        Movie[] returned = new Movie[]{first};
        doReturn(returned).when(repository).findAll();
        manager.add(first);
        Movie[] expected = new Movie[]{first};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

}
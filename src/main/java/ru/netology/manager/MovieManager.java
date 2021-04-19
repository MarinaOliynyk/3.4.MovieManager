package ru.netology.manager;

import ru.netology.domain.Movie;


public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int movieCount = 10;

    public MovieManager() {
    }

    public MovieManager(int movieCount) {
        this.movieCount = movieCount;
    }

    public void add(Movie movie) {
        // создаём новый массив размером на единицу больше
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] getAll() {
        Movie[] result = new Movie[movies.length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }


//    public Movie[] getLastMovie() {
//        int length = movieCount;
//        if (length > movies.length) {
//            length = movies.length;
//        }
//
//        Movie[] result = new Movie[length];
//
//        for (int i = 0; i < length; i++) {
//            int index = movies.length - i - 1;
//            result[i] = movies[index];
//        }
//        return result;
//    }

    public Movie[]getMovies(){
        Movie[]result = new Movie[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length-i-1;
            result[i]= movies[index];
        }
        Movie[]resultList = new Movie[movieCount];
        for (int i = 0; i < resultList.length; i++) {
            resultList[i]=result[i];
        }
        return resultList;
    }
}

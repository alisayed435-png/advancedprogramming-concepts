import thro.fpk.*;


import org.junit.jupiter.api.*;

import java.util.List;


public class MovieProcessorTest {


    MovieProcessor movieProcessor = new MovieProcessor();


    @Test
    public void testFetchMovies() {
        Movie movie = new Movie();
        movie.setTitle("The Matrix");
        movie.setYear("1999");
        movie.setImdbID("tt0133093");
        movie.setType("movie");
        List<Movie> testList = movieProcessor.fetchMoviesFromMock("Matrix");
        assert !testList.isEmpty();
        assert testList.contains(movie);
    }

    @Test
    public void testFetchRecommendations() {
        List<Movie> testList = movieProcessor.fetchRecommendations();
        assert !testList.isEmpty();
    }

    @Test
    public void testFilterMoviesStreamByYear() {
        // Example: Implement test logic
    }


    @Test
    public void testGenerateInfiniteStream() {
        // Example: Implement test logic for infinite stream
    }

    @Test
    public void testProcessMovies() {
        // Example: Implement test logic finite stream
    }
}
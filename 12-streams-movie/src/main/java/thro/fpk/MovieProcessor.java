package thro.fpk;

import java.util.List;
import java.util.Random;

import static java.lang.String.format;


public class MovieProcessor {

    public List<Movie> fetchMovies(String searchQuery) {
        return MovieAPIConnector.fetchMovies(searchQuery);
    }

    public List<Movie> fetchMoviesFromMock(String searchQuery) {
        return MovieAPIConnector.mockAPIFetchMovies(searchQuery);
    }

    private static String generateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(1999999) + 1;
        return format("%07d", randomNumber);
    }

    public List<Movie> fetchRecommendations() {

        return MovieAPIConnector.fetchRecommendation(generateRandomNumber());
    }

    public List<Movie> fetchRecommendationsFromMock() {
        int[] mockedFilmIds = {133093, 234215, 242653, 120737, 167261, 167260, 110912,137523};
        Random random = new Random();
        int randomNumber = random.nextInt(mockedFilmIds.length);
        String searchQuery = String.format("%07d",mockedFilmIds[randomNumber]);
        return MovieAPIConnector.mockAPIFetchRecommendation(searchQuery);
    }
}
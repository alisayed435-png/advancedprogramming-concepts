package thro.fpk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import com.google.gson.*;

public class MovieAPIConnector {

    // never ever put your API key in the code, we only do this in this exercise !!!
    // use an .env file or a secret manager like GitHub secrets
    private static final String API_KEY = "395f076a";
    private static final String API_URL = "https://www.omdbapi.com/";

    // Fetch movies from external API
    static List<Movie> fetchMovies(String searchQuery) {
        try {
            // Ensure correct order of parameters: `s` before `apikey`
            String url = API_URL + "?s=" + searchQuery + "&apikey=" + API_KEY;
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return parseMoviesFromResponse(response.toString());
            } else {
                System.out.println("API call failed with response code: " + responseCode);
                System.out.println("Using mock data.");
                return mockAPIFetchMovies(searchQuery);
            }
        } catch (Exception e) {
            System.out.println("API call failed, using mock data.");
            return mockAPIFetchMovies(searchQuery);
        }
    }

    static List<Movie> fetchRecommendation(String searchQuery) {
        try {
            // Ensure correct order of parameters: `s` before `apikey`
            String url = API_URL + "?i=tt" + searchQuery + "&apikey=" + API_KEY;
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return parseMoviesFromResponse(response.toString());
            } else {
                System.out.println("API call failed with response code: " + responseCode);
                System.out.println("Using mock data.");
                return mockAPIFetchRecommendation(searchQuery);
            }
        } catch (Exception e) {
            System.out.println("API call failed, using mock data.");
            return mockAPIFetchRecommendation(searchQuery);
        }
    }


    // Parse movies from API response
    private static List<Movie> parseMoviesFromResponse(String jsonResponse) {
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        if (jsonObject.has("Search")) {
            JsonArray searchResults = jsonObject.getAsJsonArray("Search");
            List<Movie> movies = new ArrayList<>();
            for (JsonElement element : searchResults) {
                movies.add(parseMovie(element.getAsJsonObject()));
            }
            return movies;
        }
        else if (jsonObject.has("Title")) {
            var recommendedMovie = parseMovie(jsonObject);
            return List.of(recommendedMovie);
        }
        return Collections.emptyList();
    }

    private static Movie parseMovie(JsonObject movieJson) {
        Movie movie = new Movie();
        movie.setTitle(movieJson.get("Title").getAsString());
        movie.setYear(movieJson.get("Year").getAsString());
        movie.setImdbID(movieJson.get("imdbID").getAsString());
        movie.setType(movieJson.get("Type").getAsString());
        return movie;
    }

    // Mock API fetch for fallback
    static List<Movie> mockAPIFetchMovies(String searchQuery) {
        List<Movie> result = mockedDB.stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(searchQuery.toLowerCase()))
                .collect(Collectors.toList());
        return result;
    }

    static List<Movie> mockAPIFetchRecommendation(String searchQuery) {
        List<Movie> result = mockedDB.stream()
                .filter(movie -> movie.getImdbID().toLowerCase().contains("tt" + searchQuery))
                .collect(Collectors.toList());
        return result;
    }

    private static Movie createMovie(String title, String year, String imdbID, String type) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setYear(year);
        movie.setImdbID(imdbID);
        movie.setType(type);
        return movie;
    }

    // mocked db list that allows to search by title
    private static final List<Movie> mockedDB = Arrays.asList(
            createMovie("The Matrix", "1999", "tt0133093", "movie"),
            createMovie("The Matrix Reloaded", "2003", "tt0234215", "movie"),
            createMovie("The Matrix Revolutions", "2003", "tt0242653", "movie"),
            createMovie("The Lord of the Rings: The Fellowship of the Ring", "2001", "tt0120737", "movie"),
            createMovie("The Lord of the Rings: The Two Towers", "2002", "tt0167261", "movie"),
            createMovie("The Lord of the Rings: The Return of the King", "2003", "tt0167260", "movie"),
            createMovie("Pulp Fiction", "1994", "tt0110912", "movie"),
            createMovie("Fight Club", "1999", "tt0137523", "movie")
    );
}
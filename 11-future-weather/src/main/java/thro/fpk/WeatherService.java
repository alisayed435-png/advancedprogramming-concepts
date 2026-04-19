package thro.fpk;



public class WeatherService {

    WeatherService() {

    }

    //our locations of interest, for an average of the western european weather
    // Rosenheim, Germany (47.8567, 12.1225)
    // Brest, France (48.3903, -4.4860)
    // Oslo, Norway (59.9139, 10.7461)

    public static void main(String[] args) throws Exception {

        String[][] locations = {
                {"47.8567", "12.1225"},
                {"48.3903", "-4.4860"},
                {"59.9139", "10.7461"}
        };

        for (String[] location : locations) {
            String lat = location[0];
            String lon = location[1];

            System.out.println(ApiClient.fetchWeatherData(lat, lon));
        }
    }
}

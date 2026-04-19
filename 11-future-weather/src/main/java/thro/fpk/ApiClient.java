package thro.fpk;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ApiClient {

    private static final String BASE_URL = "https://api.open-meteo.com/";
    private static OpenMeteoApi apiService;

    public static WeatherResponse fetchWeatherData(String latitude, String longitude) throws IOException {
        if (apiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiService = retrofit.create(OpenMeteoApi.class);
        }

        return apiService.getWeather(latitude, longitude, true).execute().body();
    }
}
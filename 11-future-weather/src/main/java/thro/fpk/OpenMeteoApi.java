package thro.fpk;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenMeteoApi {
    @GET("v1/forecast")
    Call<WeatherResponse> getWeather(
        @Query("latitude") String latitude,
        @Query("longitude") String longitude,
        @Query("current_weather") boolean currentWeather
    );
}


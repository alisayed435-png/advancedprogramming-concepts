package thro.fpk;

import com.google.gson.annotations.SerializedName;

public record WeatherResponse(
    @SerializedName("current_weather") CurrentWeather currentWeather
) {

}

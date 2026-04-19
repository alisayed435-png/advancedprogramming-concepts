package thro.fpk;

import com.google.gson.annotations.SerializedName;

public record CurrentWeather(
        double temperature,
        @SerializedName("weathercode") int weatherCode
) {}

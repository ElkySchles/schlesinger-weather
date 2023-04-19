package weiss.weather;

import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherServiceTest {
    @Test
    public void getCurrentWeather(){

        //given
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        WeatherService service = retrofit.create(WeatherService.class);
        //when
        CurrentWeather weather = service.getCurrentWeather("New York").blockingFirst();
        //then
        assertNotNull(weather);
        assertNotNull(weather.getWeather().get(0).getDescription());
        assertTrue(weather.getMain().getTemp() > 0);
    }

    @Test
    public void getFiveDayForecast(){

        //given
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        WeatherService service = retrofit.create(WeatherService.class);
        //when
        FiveDayForecast weather = service.getFiveDayForecast("New York").blockingFirst();
        //then
        assertNotNull(weather);
        assertNotNull(weather.getList().get(0).getClouds());
        assertTrue(weather.getList().get(0).getVisibility() > 0);



    }


}
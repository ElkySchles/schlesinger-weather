package weiss.weather;

import dagger.Module;
import dagger.Provides;
//import weatherService.OpenWeatherMapService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class OpenWeatherMapServiceModule {
    @Provides
    public WeatherService providesOpenWeatherMapService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        WeatherService service = retrofit.create(WeatherService.class);
        return service;
    }
}

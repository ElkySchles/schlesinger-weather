package weiss.weather;

import io.reactivex.rxjava3.core.Observable;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {
    @Test
    public void getCurrentWeather(){
        //given
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);
        //when
        CurrentWeather weather = service.getCurrentWeather("New York").blockingFirst();
        //then
        assertNotNull(weather);
        assertNotNull(weather.getWeather().get(0).getDescription());
        assertTrue(weather.getMain().getTemp() > 0);
    }


}
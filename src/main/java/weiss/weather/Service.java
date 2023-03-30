package weiss.weather;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {
    @GET("/data/2.5/weather?appid=f3ec282cc665b6c18620c103602eba6b&units=imperial")
    Observable<CurrentWeather> getCurrentWeather(@Query("q") String location);

    @GET("/data/2.5/forecast?appid=f3ec282cc665b6c18620c103602eba6b&units=imperial")
    Observable<FiveDayForecast> getFiveDayForecast(@Query("q") String location);

    //get 5 day forecast, just test it the same way you test the other one.
}

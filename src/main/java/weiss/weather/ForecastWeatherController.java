package weiss.weather;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ForecastWeatherController {
    private CurrentWeatherView view;
    private WeatherService service;
    public ForecastWeatherController(

        CurrentWeatherView view,

        WeatherService service

        ){
        this.view = view;
        this.service = service;
    }

    public void requestForecast(String location) {

        Disposable disposable = service.getFiveDayForecast(location)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(
                        fiveDayForecast -> {
                            view.setFiveDayForecast(fiveDayForecast);
                        }
                        ,
                        Throwable::printStackTrace

                );
    }


}

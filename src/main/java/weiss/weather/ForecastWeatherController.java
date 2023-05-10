package weiss.weather;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import javax.inject.Inject;

public class ForecastWeatherController {
    private final CurrentWeatherView view;

    private final WeatherService service;

    @Inject
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
                        fiveDayForecast -> view.setFiveDayForecast(fiveDayForecast),
                        Throwable::printStackTrace);
    }


}

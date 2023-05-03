package weiss.weather;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ForecastWeatherControllerTest {

    static {
        //makes service return immediately
        RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxJavaPlugins.setNewThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
    }

    @Test
    void requestForecast(){
        //given
        WeatherService service = mock();
        CurrentWeatherView view = mock();
        ForecastWeatherController controller = new ForecastWeatherController(view, service);
        FiveDayForecast fiveDayForecast = mock();
        Observable<FiveDayForecast> observable = Observable.just(fiveDayForecast);
        doReturn(observable).when(service).getFiveDayForecast("New York");

        //when
        controller.requestForecast("New York");

        //then
        verify(service).getFiveDayForecast("New York");
        verify(view).setFiveDayForecast(fiveDayForecast);
    }

}
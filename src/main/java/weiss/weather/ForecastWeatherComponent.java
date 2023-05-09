package weiss.weather;
import dagger.Component;
//import .ForecastWeatherFrame;

import javax.inject.Singleton;
@Singleton
@Component(modules = {OpenWeatherMapServiceModule.class})
public interface ForecastWeatherComponent {
    CurrentWeatherFrame providesCurrentWeatherFrame();
}

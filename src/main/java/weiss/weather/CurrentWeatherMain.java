package weiss.weather;

public class CurrentWeatherMain {

    public static void main(String[] args) {

        ForecastWeatherComponent component = DaggerForecastWeatherComponent
                .builder()
                .build();
        CurrentWeatherFrame frame = component.providesCurrentWeatherFrame;
        frame.setVisible(true);
    }
}

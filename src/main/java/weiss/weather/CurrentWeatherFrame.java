package weiss.weather;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class CurrentWeatherFrame extends JFrame {
    private JButton submit = new JButton("Submit");
    private TextField location = new TextField("New York");

    private CurrentWeatherView view = new CurrentWeatherView();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build();
    WeatherService service = retrofit.create(WeatherService.class);

    private ForecastWeatherController controller;

    public CurrentWeatherFrame(){
        setSize(800,600);
        setTitle("Current Weather");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //setting the panel layout

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        setContentPane(mainPanel);
        mainPanel.add(view, BorderLayout.CENTER);
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.add(location, BorderLayout.CENTER);
        northPanel.add(submit, BorderLayout.EAST);
        mainPanel.add(northPanel, BorderLayout.NORTH);
        controller = new ForecastWeatherController(view, service);

        //FiveDayForecast ogWeather = service.getFiveDayForecast("New York").;
        controller.requestForecast("New York");

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.requestForecast(location.getText());

            }
        });

    }



}

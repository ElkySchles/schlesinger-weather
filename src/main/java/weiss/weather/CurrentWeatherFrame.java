package weiss.weather;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrentWeatherFrame extends JFrame {
    JButton submit = new JButton("Submit");
    TextField location = new TextField("New York");

    private CurrentWeatherView view = new CurrentWeatherView();
    public CurrentWeatherFrame(){
        setSize(800,600);
        setTitle("Current Weather");
        setDefaultCloseOperation(EXIT_ON_CLOSE);



        //creating the information from the weather api
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        WeatherService service = retrofit.create(WeatherService.class);


        //setting the panel layout

        //TextField location = new TextField("ENTER LOCATION" );
        //JButton submit = new JButton("Submit");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        setContentPane(mainPanel);
        mainPanel.add(view, BorderLayout.CENTER);
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.add(location, BorderLayout.CENTER);
        northPanel.add(submit, BorderLayout.EAST);
        mainPanel.add(northPanel, BorderLayout.NORTH);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FiveDayForecast weather = service.getFiveDayForecast(location.getText()).blockingFirst();
                view.setFiveDayForecast(weather);

                requestFocus();
            }
        });



    }



}

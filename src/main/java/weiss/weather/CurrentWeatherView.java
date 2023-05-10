package weiss.weather;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.swing.*;
import java.awt.*;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CurrentWeatherView extends JComponent {

    @Inject
    public CurrentWeatherView(){

    }
    FiveDayForecast weather;
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);


        int height = getHeight();
        //moving the origin to the lower left hand corner.
        g.translate(0, height);
        if(weather == null){
            return;
        }

        double firstTemperature = weather.getList().get(0).getMain().getTemp();
        Double temperature;
        int currentHour = 0;
        for(int i = 0; i < weather.getList().size(); i++) {
            temperature = weather.getList().get(i).getMain().getTemp();


            g.drawLine(currentHour, (int) -firstTemperature * 5, currentHour + 20, (int) -temperature * 5);
            currentHour +=20;
            firstTemperature = temperature;
        }


    }
    public void setFiveDayForecast(FiveDayForecast weather)
    {
        this.weather = weather;
        repaint();
    }
}

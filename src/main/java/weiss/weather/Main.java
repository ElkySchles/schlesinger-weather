
package weiss.weather;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Main {


    private Double feelsLike;

    private Long grndLevel;

    private Long humidity;

    private Long pressure;

    private Long seaLevel;

    private Double temp;

    private Double tempKf;

    private Double tempMax;

    private Double tempMin;

    public Double getFeelsLike() {

        return feelsLike;
    }

    public void setFeelsLike(Double feelsLike) {

        this.feelsLike = feelsLike;
    }

    public Long getGrndLevel() {

        return grndLevel;
    }

    public void setGrndLevel(Long grndLevel) {

        this.grndLevel = grndLevel;
    }

    public Long getHumidity() {

        return humidity;
    }

    public void setHumidity(Long humidity) {

        this.humidity = humidity;
    }

    public Long getPressure() {

        return pressure;
    }

    public void setPressure(Long pressure) {

        this.pressure = pressure;
    }

    public Long getSeaLevel() {

        return seaLevel;
    }

    public void setSeaLevel(Long seaLevel) {

        this.seaLevel = seaLevel;
    }

    public Double getTemp() {

        return temp;
    }

    public void setTemp(Double temp) {

        this.temp = temp;
    }

    public Double getTempKf() {

        return tempKf;
    }

    public void setTempKf(Double tempKf) {

        this.tempKf = tempKf;
    }

    public Double getTempMax() {

        return tempMax;
    }

    public void setTempMax(Double tempMax) {

        this.tempMax = tempMax;
    }

    public Double getTempMin() {

        return tempMin;
    }

    public void setTempMin(Double tempMin) {

        this.tempMin = tempMin;
    }

}

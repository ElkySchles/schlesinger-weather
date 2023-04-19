
package weiss.weather;

import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class FiveDayForecast {


    private City city;

    private Long cnt;

    private String cod;

    private java.util.List<weiss.weather.List> list;

    private Long message;

    public City getCity() {

        return city;
    }

    public void setCity(City city) {

        this.city = city;
    }

    public Long getCnt() {

        return cnt;
    }

    public void setCnt(Long cnt) {

        this.cnt = cnt;
    }

    public String getCod() {

        return cod;
    }

    public void setCod(String cod) {

        this.cod = cod;
    }

    public java.util.List<weiss.weather.List> getList() {

        return list;
    }

    public void setList(java.util.List<weiss.weather.List> list) {

        this.list = list;
    }

    public Long getMessage() {

        return message;
    }

    public void setMessage(Long message) {

        this.message = message;
    }

}

package hu.ait.android.weatherapp.data;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by mateocar on 12/1/15.
 */
public class City extends SugarRecord<City> implements Serializable {

    private String cityName;

    public City() {

    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}

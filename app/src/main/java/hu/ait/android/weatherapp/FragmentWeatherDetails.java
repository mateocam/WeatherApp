package hu.ait.android.weatherapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;

import hu.ait.android.weatherapp.data.CityResult;

/**
 * Created by mateocar on 12/1/15.
 */
public class FragmentWeatherDetails extends android.support.v4.app.Fragment {

    public static final String TAG = "TAG_DETAILS";
    private TextView tvMinTmp;
    private TextView tvMaxTmp;
    private TextView tvCityName;
    private TextView tvHumidity;
    private TextView tvSunset;
    private TextView tvSunrise;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_details
                , container, false
        );

        tvCityName = (TextView) rootView.findViewById(R.id.tvCityName);
        tvMinTmp = (TextView) rootView.findViewById(R.id.tvMinTmp);
        tvMaxTmp = (TextView) rootView.findViewById(R.id.tvMaxTmp);
        tvHumidity = (TextView) rootView.findViewById(R.id.tvHumidity);
        tvSunset = (TextView) rootView.findViewById(R.id.tvSunset);
        tvSunrise = (TextView) rootView.findViewById(R.id.tvSunrise);

        return rootView;
    }

    public void setDetails(CityResult cityResult) {

        if (cityResult.getWeather() != null) {
            tvCityName.setText("City: " + cityResult.getName());
            tvMinTmp.setText("\t\tMin Temperature: " + cityResult.getMain().getTempMin());
            tvMaxTmp.setText("\t\tMax Temperature: " + cityResult.getMain().getTempMax());
            tvHumidity.setText("\t\tHumidity: " + cityResult.getMain().getHumidity());
            tvSunset.setText("\t\tSunset: " + (new Date((long)cityResult.getSys().getSunset()*1000)).toString());
            tvSunrise.setText("\t\tSunrise: " + (new Date((long)cityResult.getSys().getSunrise()*1000)).toString());
        } else {
            tvCityName.setText("The name of the city is unrecognizable");
        }
    }
}

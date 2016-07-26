package hu.ait.android.weatherapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import hu.ait.android.weatherapp.data.CityResult;

/**
 * Created by mateocar on 12/1/15.
 */
public class FragmentMainInfo extends android.support.v4.app.Fragment {

    public static final String TAG = "TAG_MAIN";
    private TextView tvCurrentTmp;
    private TextView tvDescription;
    private TextView tvCityName;
    private ImageView ivWeatherIcon;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_main_info, container, false);

        tvCityName = (TextView) rootView.findViewById(R.id.tvCityName);
        tvCurrentTmp = (TextView) rootView.findViewById(R.id.tvCurrentTmp);
        tvDescription = (TextView) rootView.findViewById(R.id.tvDescription);
        ivWeatherIcon = (ImageView) rootView.findViewById(R.id.ivWeatherIcon);

        return rootView;
    }

    public void setMainInfo(CityResult cityResult) {
        if (cityResult.getWeather() != null) {
            tvCityName.setText("City: " + cityResult.getName());
            tvCurrentTmp.setText("\t\tCurrent Temperature: " + cityResult.getMain().getTemp());
            tvDescription.setText("\t\tDescription: " + cityResult.getWeather().get(0).getDescription());
            String imgId = cityResult.getWeather().get(0).getIcon();
            Glide.with(this).load("http://openweathermap.org/img/w/"+imgId+".png").into(ivWeatherIcon);
        } else {
            tvCityName.setText("The name of the city is unrecognizable");
        }
    }

}

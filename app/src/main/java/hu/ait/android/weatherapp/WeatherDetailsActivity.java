package hu.ait.android.weatherapp;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import de.greenrobot.event.EventBus;
import hu.ait.android.weatherapp.adapter.CityAdapter;
import hu.ait.android.weatherapp.adapter.CityPagerAdapter;
import hu.ait.android.weatherapp.data.CityResult;
import hu.ait.android.weatherapp.network.HttpAsyncTask;


public class WeatherDetailsActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_details);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new CityPagerAdapter(getSupportFragmentManager()));

        cityName = getIntent().getStringExtra(CityAdapter.KEY_INFO);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);

        new HttpAsyncTask(getApplicationContext()).execute(
                "http://api.openweathermap.org/data/2.5/weather?q=" + cityName.replace(" ", "") +
                        "&units=metric&appid=b8e420d0065cfc59c1c0ff795ed51897"
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(CityResult cityResult) {
        /*String mainFragmentTag = getFragmentTag(R.id.pager, 0);
                                                // 0, because it is the index of the first page
        FragmentMainInfo fragmentMainInfo = (FragmentMainInfo)
                getSupportFragmentManager().findFragmentByTag(mainFragmentTag);
        fragmentMainInfo.setMainInfo(cityResult);

        String detailsFragmentTag = getFragmentTag(R.id.pager, 1);
                                                // 1, because it is the index of the second page
        FragmentWeatherDetails fragmentDetails = (FragmentWeatherDetails)
                getSupportFragmentManager().findFragmentByTag(
                detailsFragmentTag);
        fragmentDetails.setDetails(cityResult);*/

        ((CityPagerAdapter)viewPager.getAdapter()).getFragmentMainInfo().setMainInfo(cityResult);
        ((CityPagerAdapter)viewPager.getAdapter()).getFragmentWeatherDetails().setDetails(cityResult);

    }

    private String getFragmentTag(int viewPagerId, int index) {
        return "android:switcher:" + viewPagerId + ":" + index;
    }

}

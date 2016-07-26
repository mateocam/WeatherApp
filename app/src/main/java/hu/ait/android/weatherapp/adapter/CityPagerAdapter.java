package hu.ait.android.weatherapp.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import hu.ait.android.weatherapp.FragmentMainInfo;
import hu.ait.android.weatherapp.FragmentWeatherDetails;

/**
 * Created by mateocar on 12/1/15.
 */
public class CityPagerAdapter extends FragmentStatePagerAdapter {

    private FragmentMainInfo fragmentMainInfo;
    private FragmentWeatherDetails fragmentWeatherDetails;

    public CityPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);

        fragmentMainInfo =  new FragmentMainInfo();
        fragmentWeatherDetails = new FragmentWeatherDetails();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Main Info";
            case 1:
                return "Weather Details";
            default:
                return "Main Info";
        }
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return fragmentMainInfo;
            case 1:
                return fragmentWeatherDetails;
            default:
                return fragmentMainInfo;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    public FragmentMainInfo getFragmentMainInfo() {
        return fragmentMainInfo;
    }

    public FragmentWeatherDetails getFragmentWeatherDetails() {
        return fragmentWeatherDetails;
    }
}

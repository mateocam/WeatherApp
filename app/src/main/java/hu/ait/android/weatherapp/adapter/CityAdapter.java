package hu.ait.android.weatherapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import hu.ait.android.weatherapp.R;
import hu.ait.android.weatherapp.WeatherDetailsActivity;
import hu.ait.android.weatherapp.data.City;

/**
 * Created by mateocar on 12/1/15.
 */
public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    public static final String KEY_INFO = "KEY_INFO";

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCity;
        public Button btnDelete;
        public RelativeLayout rowCity;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCity = (TextView) itemView.findViewById(R.id.tvCity);
            btnDelete = (Button) itemView.findViewById(R.id.btnDelete);
            rowCity = (RelativeLayout) itemView.findViewById(R.id.rowCity);
        }
    }

    private List<City> citiesList;
    private Context context;
    //private int lastPosition = -1;

    public CityAdapter(List<City> placesList, Context context) {
        this.citiesList = placesList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_city, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.tvCity.setText(citiesList.get(position).getCityName());
        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeCity(position);
                v.setBackgroundResource(R.drawable.ic_clear_black_24dp);

            }
        });

        viewHolder.rowCity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intentStart = new Intent(context,
                        WeatherDetailsActivity.class);
                intentStart.putExtra(KEY_INFO,citiesList.get(position).getCityName());
                v.getContext().startActivity(intentStart);
            }
        });
    }

    @Override
    public int getItemCount() {
        return citiesList.size();
    }

    public void addCity(City city) {
        city.save();
        citiesList.add(city);
        notifyDataSetChanged();
    }

    public void removeCity(int index) {
        citiesList.get(index).delete();
        citiesList.remove(index);
        notifyDataSetChanged();
    }

    public City getCity(int i) {
        return citiesList.get(i);
    }

}

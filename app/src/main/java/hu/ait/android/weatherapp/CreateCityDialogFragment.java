package hu.ait.android.weatherapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;

import hu.ait.android.weatherapp.adapter.CityAdapter;
import hu.ait.android.weatherapp.data.City;

/**
 * Created by mateocar on 12/2/15.
 */
public class CreateCityDialogFragment extends DialogFragment implements
        DialogInterface.OnClickListener{

    public static final String TAG = "CreateCityFragment";
    EditText input;

    public interface CreateCityDialogFragmentInterface {
        public void addCityFragmentResult(City input);
    }

    private CreateCityDialogFragmentInterface createCityFragmentInterface;

    public CreateCityDialogFragment () {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            createCityFragmentInterface = (CreateCityDialogFragmentInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + "must implement CreateCityDialogFragmentInterface");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getString(R.string.add_new_city));
        input = new EditText(getActivity());
        builder.setView(input);
        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (input.getText().toString().equals("")) {
                    input.setError(getString(R.string.must_add));
                } else {
                    City city = new City();
                    city.setCityName(input.getText().toString());
                    createCityFragmentInterface.addCityFragmentResult(city);

                }
            }
        });


        AlertDialog alert = builder.create();
        return alert;
    }

    @Override
    public void onClick(DialogInterface dialog, int choice) {
        if(input.getText().toString().equals("")){
            input.setError(getString(R.string.must_add));
        }
        else {
            City city = new City();
            city.setCityName(input.getText().toString());
            createCityFragmentInterface.addCityFragmentResult(city);
        }
    }
}



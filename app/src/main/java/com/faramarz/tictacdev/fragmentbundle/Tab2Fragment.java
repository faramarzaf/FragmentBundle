package com.faramarz.tictacdev.fragmentbundle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import static com.faramarz.tictacdev.fragmentbundle.PublicKeys.KEY_CACHE;
import static com.faramarz.tictacdev.fragmentbundle.PublicKeys.KEY_DAY;
import static com.faramarz.tictacdev.fragmentbundle.PublicKeys.KEY_FEMALE;
import static com.faramarz.tictacdev.fragmentbundle.PublicKeys.KEY_MALE;
import static com.faramarz.tictacdev.fragmentbundle.PublicKeys.KEY_MONTH;
import static com.faramarz.tictacdev.fragmentbundle.PublicKeys.KEY_YEAR;

public class Tab2Fragment extends Fragment {

    TextView txtCash, txtReceivedDate, txtGender;
    Bundle bundle;
    String myInt, strMale, strFemale;
    long myyear, myday, mymonth;

    public Tab2Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        txtCash = view.findViewById(R.id.txtCash);
        txtReceivedDate = view.findViewById(R.id.txtReceivedDate);
        txtGender = view.findViewById(R.id.txtGender);
        receiveData();
        return view;
    }

    private void receiveData() {
        bundle = this.getArguments();
        if (bundle != null) {
            myInt = bundle.getString(KEY_CACHE, "");
            strFemale = bundle.getString(KEY_FEMALE, "");
            strMale = bundle.getString(KEY_MALE, "");
            myday = bundle.getLong(KEY_DAY, 0);
            mymonth = bundle.getLong(KEY_MONTH, 0);
            myyear = bundle.getLong(KEY_YEAR, 0);
            if (bundle.containsKey(KEY_MALE)) {
                txtGender.setText(strMale);
            } else if (bundle.containsKey(KEY_FEMALE)) {
                txtGender.setText(strFemale);
            }

            txtCash.setText(myInt);
            txtReceivedDate.setText(new StringBuilder()
                    .append(myday)
                    .append("-")
                    .append(mymonth)
                    .append("-")
                    .append(myyear)
                    .toString());

            // date formatter

        }
    }


}

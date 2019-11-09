package com.faramarz.tictacdev.fragmentbundle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import static com.faramarz.tictacdev.fragmentbundle.PublicValue.KEY_CACHE;
import static com.faramarz.tictacdev.fragmentbundle.PublicValue.KEY_DAY;
import static com.faramarz.tictacdev.fragmentbundle.PublicValue.KEY_MONTH;
import static com.faramarz.tictacdev.fragmentbundle.PublicValue.KEY_YEAR;

public class Tab2Fragment extends Fragment {

    TextView txtCash, txtReceivedDate;
    Bundle bundle;
    String myInt;
    long myyear, myday, mymonth;

    public Tab2Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        txtCash = view.findViewById(R.id.txtCash);
        txtReceivedDate = view.findViewById(R.id.txtReceivedDate);
        receiveData();
        return view;
    }

    private void receiveData() {
        bundle = this.getArguments();
        if (bundle != null) {
            myInt = bundle.getString(KEY_CACHE, "");
            myday = bundle.getLong(KEY_DAY, 0);
            mymonth = bundle.getLong(KEY_MONTH, 0);
            myyear = bundle.getLong(KEY_YEAR, 0);
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

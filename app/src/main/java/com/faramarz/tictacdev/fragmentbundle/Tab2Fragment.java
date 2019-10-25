package com.faramarz.tictacdev.fragmentbundle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Tab2Fragment extends Fragment {

    TextView txtCash;
    Bundle bundle;
    String myInt;

    public Tab2Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        txtCash = view.findViewById(R.id.txtCash);
        receiveData();
        return view;

    }

    private void receiveData() {
        bundle = this.getArguments();
        if (bundle != null) {
            myInt = bundle.getString("myCash", "");
            txtCash.setText(myInt);
        }
    }
}

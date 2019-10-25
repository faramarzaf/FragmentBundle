package com.faramarz.tictacdev.fragmentbundle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;


public class Tab1Fragment extends Fragment implements View.OnClickListener {

    EditText edtCash;
    Button btnPassCash;
    TabLayout tabhost;
    Bundle bundle;
    String myCash;
    Tab2Fragment fragment;

    public Tab1Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        edtCash = view.findViewById(R.id.edtCash);
        btnPassCash = view.findViewById(R.id.btnPassCash);
        tabhost = view.findViewById(R.id.tabLayout);
        btnPassCash.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        sendData();
        navigateToSecondTab();
    }

    private void navigateToSecondTab() {
        tabhost = getActivity().findViewById(R.id.tabLayout);
        tabhost.getTabAt(1).select();
    }

    private void sendData() {
        bundle = new Bundle();
        myCash = edtCash.getText().toString();
        bundle.putString("myCash", myCash);
        fragment = new Tab2Fragment();
        fragment.setArguments(bundle);
        if (getFragmentManager() != null) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame2, fragment).commit();
        }
    }

}

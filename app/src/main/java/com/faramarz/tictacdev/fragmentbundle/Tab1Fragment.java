package com.faramarz.tictacdev.fragmentbundle;

import android.app.DatePickerDialog;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

import java.util.Calendar;

import static com.faramarz.tictacdev.fragmentbundle.PublicKeys.KEY_CACHE;
import static com.faramarz.tictacdev.fragmentbundle.PublicKeys.KEY_DAY;
import static com.faramarz.tictacdev.fragmentbundle.PublicKeys.KEY_FEMALE;
import static com.faramarz.tictacdev.fragmentbundle.PublicKeys.KEY_MALE;
import static com.faramarz.tictacdev.fragmentbundle.PublicKeys.KEY_MONTH;
import static com.faramarz.tictacdev.fragmentbundle.PublicKeys.KEY_YEAR;


public class Tab1Fragment extends Fragment implements View.OnClickListener {

    private EditText edtCash;
    private Button btnPassCash;
    private TabLayout tabhost;
    private Bundle bundle;
    private Tab2Fragment fragment;
    private TextView txtSelectDate;
    private DatePickerDialog datePickerDialog;
    private RadioGroup rg;
    private RadioButton rbMale, rbFemale;

    private int mYear, mMonth, mDay;
    private int currYear, currMonth, currDay;
    private String myCash;

    public Tab1Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        edtCash = view.findViewById(R.id.edtCash);
        btnPassCash = view.findViewById(R.id.btnPassData);
        tabhost = view.findViewById(R.id.tabLayout);
        txtSelectDate = view.findViewById(R.id.txtSelectDate);

        rbMale = view.findViewById(R.id.rbMale);
        rbFemale = view.findViewById(R.id.rbFemale);
        rg = view.findViewById(R.id.rgProfile);


        txtSelectDate.setPaintFlags(txtSelectDate.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btnPassCash.setOnClickListener(this);
        txtSelectDate.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPassData:
                sendData();
                navigateToSecondTab();
                break;

            case R.id.txtSelectDate:
                getDate();
                break;

        }
    }

    private void getDate() {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        if (getContext() == null)
            return;

        datePickerDialog = new DatePickerDialog(getContext(), R.style.DatePickerTheme, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(getActivity(), "" + year + monthOfYear + dayOfMonth, Toast.LENGTH_SHORT).show();
                currYear = year;
                currMonth = monthOfYear;
                currDay = dayOfMonth;

            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void navigateToSecondTab() {
        tabhost = getActivity().findViewById(R.id.tabLayout);
        tabhost.getTabAt(1).select();
    }

    private void sendData() {
        bundle = new Bundle();
        myCash = edtCash.getText().toString();
        bundle.putString(KEY_CACHE, myCash);
        bundle.putLong(KEY_DAY, currDay);
        bundle.putLong(KEY_MONTH, currMonth);
        bundle.putLong(KEY_YEAR, currYear);
        int id = rg.getCheckedRadioButtonId();
        //if (rg.getCheckedRadioButtonId() != -1)
        if (id == R.id.rbMale) {
            bundle.putString(KEY_MALE, rbMale.getText().toString());
        } else if (id == R.id.rbFemale) {
            bundle.putString(KEY_FEMALE, rbFemale.getText().toString());
        }

        fragment = new Tab2Fragment();
        fragment.setArguments(bundle);
        if (getActivity().getFragmentManager() != null)
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame2, fragment).commit();

    }

}

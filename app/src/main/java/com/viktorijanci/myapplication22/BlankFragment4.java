package com.viktorijanci.myapplication22;


import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BlankFragment4 extends DialogFragment {
    final private static String TAG="FragmentGlavni4";

    private CalendarView mCalendarView;

    public BlankFragment4() {
        // Required empty public constructor
    }
    public interface BlankFragment4Listener{
        void onFinishBlankFragment4(String date, Dialog dialog);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v=inflater.inflate(R.layout.blank_fragment4, container, false);
        mCalendarView= (CalendarView) v.findViewById(R.id.calendarView);
        Date mojdatum = new Date();
        mojdatum.setTime(mCalendarView.getDate());
        String date = new SimpleDateFormat("dd/MM/yyyy").format(mojdatum);
        getDialog().setTitle(date);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                BlankFragment4Listener activity = (BlankFragment4Listener) getActivity();
                Log.i(TAG, String.valueOf(activity));
                int month1=month+1;
                activity.onFinishBlankFragment4(dayOfMonth+"/"+month1+"/"+year,getDialog());
            }
        });
        return v;
    }
}

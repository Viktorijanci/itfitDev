package com.viktorijanci.myapplication22;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

public class BlankFragment2 extends Fragment{
    final private static String TAG="FragmentGlavni2";

    interface promeni2 {
        public void promeniProgress2();
    }

    public static BlankFragment2 newInstance() {
        return new BlankFragment2();
    }
    FragmentTransaction ft;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.blank_fragment2, container, false);
        Log.i(TAG, String.valueOf(v));
        final Context moje = v.getContext();
        RadioGroup grupa = v.findViewById(R.id.radioGroup);
        grupa.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.i(TAG, "uspesno");
                FragmentManager fm = getFragmentManager();
                BlankFragment3 mFragment = new BlankFragment3();
                ft = fm.beginTransaction();
                ft.replace(R.id.mojLayout,mFragment);
                ft.addToBackStack(null);
                ft.commit();
                ((promeni2)getActivity()).promeniProgress2();
            }
        });
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

}

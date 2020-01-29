package com.viktorijanci.myapplication22;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment6 extends Fragment {
    final private static String TAG="FragmentGlavni6";
    public BlankFragment6() {
        // Required empty public constructor
    }
    public interface promeni6{
        void promeniProgress6();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.blank_fragment6, container, false);
        return v;
    }

}

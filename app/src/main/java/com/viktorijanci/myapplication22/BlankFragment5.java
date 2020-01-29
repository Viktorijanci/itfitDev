package com.viktorijanci.myapplication22;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment5 extends Fragment {
    final private static String TAG="FragmentGlavni5";
    public BlankFragment5() {
        // Required empty public constructor
    }
    public interface promeni5{
        void promeniProgress5();
    }
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.blank_fragment5, container, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = v.findViewById(R.id.editText);
                EditText editText1 = v.findViewById(R.id.editText3);
                if (!editText.getText().toString().equals("") && !editText1.getText().toString().equals("")) {
                    Log.i(TAG, "uspesno");
                    FragmentManager fm = getFragmentManager();
                    BlankFragment6 mFragment = new BlankFragment6();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.mojLayout, mFragment);
                    ft.addToBackStack(null);
                    ft.commit();
                    ((promeni5) getActivity()).promeniProgress5();
                }
            }
        });
        return v;
    }

}

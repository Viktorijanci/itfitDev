package com.viktorijanci.myapplication22;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


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
        final RadioGroup radioGroup = v.findViewById(R.id.radioGroup);
        final EditText editText = v.findViewById(R.id.editText4);
        Log.i(TAG, String.valueOf(radioGroup));
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editText.getText().toString().equals("") && radioGroup.getCheckedRadioButtonId()!=-1){
                    Log.i(TAG, "uspesno");
                    FragmentManager fm = getFragmentManager();
                    BlankFragment7 mFragment = new BlankFragment7();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.mojLayout, mFragment);
                    ft.addToBackStack(null);
                    ft.commit();
                    ((promeni6) getActivity()).promeniProgress6();
                }
            }
        });
        return v;
    }

}

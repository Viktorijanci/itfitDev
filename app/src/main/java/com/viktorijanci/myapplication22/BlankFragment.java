package com.viktorijanci.myapplication22;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

public class BlankFragment extends Fragment {
    final private static String TAG="FragmentGlavni";

    public static BlankFragment newInstance() {
        return new BlankFragment();
    }
    interface promeni {
        public void promeniProgress();
    }

    FragmentTransaction ft;

    @Override
    public void onAttach(Context context){
        super.onAttach(getContext());
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View v=inflater.inflate(R.layout.blank_fragment, container, false);
        Log.i(TAG, String.valueOf(v));
        final Context moje = v.getContext();
        RadioGroup grupa = v.findViewById(R.id.radioGroup);
        grupa.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.i(TAG, "uspesno");
                FragmentManager fm = getFragmentManager();
                BlankFragment2 mFragment = new BlankFragment2();
                ft = fm.beginTransaction();
                ft.replace(R.id.mojLayout,mFragment);
                ft.addToBackStack(null);
                ft.commit();
                ((promeni)getActivity()).promeniProgress();
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

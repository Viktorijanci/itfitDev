package com.viktorijanci.myapplication22;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment7 extends Fragment {
    public BlankFragment7() {
        // Required empty public constructor
    }
    public interface promeni7 {
        void promeniProgress7();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.blank_fragment7, container, false);
        Button button = v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((promeni7) getActivity()).promeniProgress7();
            }
        });
        return v;
    }

}

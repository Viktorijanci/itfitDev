package com.viktorijanci.myapplication22;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BlankFragment3 extends Fragment {
    final private static String TAG="FragmentGlavni3";
    public interface get {
        void getEditText(EditText editText);
        void promeniProgress3(String datum, int pol);
    }
    public static BlankFragment3 newInstance() {
        return new BlankFragment3();
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.blank_fragment3, container, false);
        Log.i(TAG, String.valueOf(v));
        final EditText mEditText = (EditText) v.findViewById(R.id.editText2);
        ((get) getActivity()).getEditText(mEditText);
        mEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "da");
                showDialog();
            }
        });
        final RadioGroup radioGroup = (RadioGroup) v.findViewById(R.id.radioGroup);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioGroup.getCheckedRadioButtonId()!=-1 && !mEditText.getText().toString().equals("")){
                    Log.i(TAG, "uspesno1");
                    FragmentManager fm = getFragmentManager();
                    BlankFragment5 mFragment = new BlankFragment5();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.mojLayout,mFragment);
                    ft.addToBackStack(null);
                    ft.commit();
                    int cilj;
                    if (radioGroup.getCheckedRadioButtonId() == R.id.radioButton5) {
                        cilj = 0;
                    } else {
                        cilj = 1;
                    }
                    ((get)getActivity()).promeniProgress3(String.valueOf(mEditText.getText()),cilj);
                }
            }
        });
        Log.i(TAG, String.valueOf(((ViewGroup) v).getChildAt(0)));
        return v;
    }
    private void showDialog(){
        FragmentManager fm = getFragmentManager();
        BlankFragment4 mojFragm = new BlankFragment4();
        mojFragm.show(fm, "blank_fragment4");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}

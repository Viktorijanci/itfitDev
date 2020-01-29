package com.viktorijanci.myapplication22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BlankFragment.promeni, BlankFragment2.promeni2, BlankFragment4.BlankFragment4Listener, BlankFragment3.get, BlankFragment5.promeni5,BlankFragment6.promeni6 {
    final private static String TAG="Glavni";
    EditText editText;
    private String readFromFileTEXT(Context context, String ime) {
        String line = null;
        try {
            String path = context.getFilesDir().getAbsolutePath();
            new File(path).mkdir();
            File fajl = new File(path+ime+".txt");
            if(!fajl.exists()) fajl.createNewFile();
            FileInputStream fileInputStream = new FileInputStream (fajl);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();

            while ( (line = bufferedReader.readLine()) != null )
                stringBuilder.append(line).append(System.getProperty("line.separator"));
            fileInputStream.close();
            line = stringBuilder.toString();

            bufferedReader.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return line;
    }
    public static boolean hasOpenedDialogs(FragmentActivity activity) {
        List<Fragment> fragments = activity.getSupportFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment instanceof DialogFragment) {
                    return true;
                }
            }
        }
        return false;
    }
    private BlankFragment mFragment = new BlankFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, String.valueOf(mFragment));
        Log.i(TAG, String.valueOf(getApplicationContext()));
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mojLayout,mFragment)
                .commit();
    }
    @Override
    public void promeniProgress(){
        ProgressBar progressBar = findViewById(R.id.progressBar2);
        progressBar.setProgress(2);
    }
    @Override
    public void promeniProgress2(){
        ProgressBar progressBar = findViewById(R.id.progressBar2);
        progressBar.setProgress(3);
    }
    @Override
    public void promeniProgress3(){
        ProgressBar progressBar = findViewById(R.id.progressBar2);
        progressBar.setProgress(4);
    }
    @Override
    public void promeniProgress5(){
        ProgressBar progressBar = findViewById(R.id.progressBar2);
        progressBar.setProgress(5);
    }
    @Override
    public void promeniProgress6(){
        ProgressBar progressBar = findViewById(R.id.progressBar2);
        progressBar.setProgress(6);
    }
    @Override
    public void onFinishBlankFragment4(String date, Dialog dialog){
        dialog.dismiss();
        editText.setText(date);
    }
    @Override
    public void getEditText(EditText editText1){
        editText=editText1;
    }
}

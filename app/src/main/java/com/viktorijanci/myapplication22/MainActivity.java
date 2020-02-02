package com.viktorijanci.myapplication22;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements BlankFragment.promeni, BlankFragment2.promeni2, BlankFragment4.BlankFragment4Listener, BlankFragment3.get, BlankFragment5.promeni5,BlankFragment6.promeni6,BlankFragment7.promeni7 {
    final private static String TAG="Glavni";
    EditText editText;
    Korisnik korisnik = new Korisnik();
    Podesavanja podesavanja = new Podesavanja();

    private String readFromFileJSON(Context context, String ime) {
        String line = null;
        try {
            String path = context.getFilesDir().getAbsolutePath();
            new File(path).mkdir();
            File fajl = new File(path+ime+".json");
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
    public static void saveToFile(String data, Context context, String ime){
        try {
            String path = context.getFilesDir().getAbsolutePath();
            new File(path).mkdir();
            File file = new File(path+ime+".json");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file,false);
            fileOutputStream.write((data + System.getProperty("line.separator")).getBytes());
        }  catch(IOException ex) {
            Log.d(TAG, Objects.requireNonNull(ex.getMessage()));
        }
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
    public void promeniProgress(int cilj){
        ProgressBar progressBar = findViewById(R.id.progressBar2);
        progressBar.setProgress(2);
        podesavanja.cilj=cilj;
    }
    @Override
    public void promeniProgress2(int aktivan){
        ProgressBar progressBar = findViewById(R.id.progressBar2);
        progressBar.setProgress(3);
        podesavanja.aktivan=aktivan;
    }
    @Override
    public void promeniProgress3(String datum, int pol){
        ProgressBar progressBar = findViewById(R.id.progressBar2);
        progressBar.setProgress(4);
        korisnik.datum=datum;
        korisnik.pol=pol;
    }
    @Override
    public void promeniProgress5(int visina, int tezina){
        ProgressBar progressBar = findViewById(R.id.progressBar2);
        progressBar.setProgress(5);
        korisnik.visina=visina;
        korisnik.tezina=tezina;
    }
    @Override
    public void promeniProgress6(int krajnji, int nedeljni){
        ProgressBar progressBar = findViewById(R.id.progressBar2);
        progressBar.setProgress(6);
        podesavanja.krajnji=krajnji;
        podesavanja.nedeljni=nedeljni;
    }
    @Override
    public void promeniProgress7(){
        podesavanja.lik=korisnik;
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("vrednost", podesavanja);
            saveToFile(jsonObject.toString(),getApplicationContext(),"podesavanja");
        }catch(JSONException e){
            e.printStackTrace();
        }
        Intent i= new Intent(this, ActualMainActivity.class);
        startActivity(i);
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

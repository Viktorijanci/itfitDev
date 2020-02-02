package com.viktorijanci.myapplication22;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LauncherActivity extends AppCompatActivity {
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Intent i;
        if(readFromFileJSON(getApplicationContext(),"podesavanja").equals("")){
            i=new Intent(this, MainActivity.class);
        } else{
            i=new Intent(this, ActualMainActivity.class);
        }
        startActivity(i);
    }
}

package com.viktorijanci.myapplication22;

import org.json.JSONException;
import org.json.JSONObject;

public class Korisnik {
    int pol;
    String datum;
    int visina;
    int tezina;
    public JSONObject toJSON(){
        JSONObject jsonObject=new JSONObject();
        try{
            jsonObject.put("pol",pol);
            jsonObject.put("datum",datum);
            jsonObject.put("visina",visina);
            jsonObject.put("tezina",tezina);
        }catch(JSONException e){
            e.printStackTrace();
        }
        return jsonObject;
    }
}

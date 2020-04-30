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
    public int getPol(){return this.pol;}
    public String getDatum(){return this.datum;}
    public int getVisina(){return this.visina;}
    public int getTezina(){return this.tezina;}
}

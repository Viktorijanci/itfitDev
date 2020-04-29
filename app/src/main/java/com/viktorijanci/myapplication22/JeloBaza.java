package com.viktorijanci.myapplication22;

import org.json.JSONException;
import org.json.JSONObject;

public class JeloBaza {
    String ime;
    int kalorija;
    int mast;
    int protein;
    public JeloBaza(String ime,int kalorija,int mast,int protein){
        this.ime=ime;
        this.kalorija=kalorija;
        this.mast=mast;
        this.protein=protein;
    }
    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("ime",ime);
            jsonObject.put("kalorija",kalorija);
            jsonObject.put("mast",mast);
            jsonObject.put("protein",protein);
        }catch(JSONException e){
            e.printStackTrace();
        }
        return jsonObject;
    }
    public String getIme() {
        return this.ime;
    }
}

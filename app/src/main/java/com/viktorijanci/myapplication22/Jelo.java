package com.viktorijanci.myapplication22;

import org.json.JSONException;
import org.json.JSONObject;

public class Jelo {
    String ime;
    int porcija;
    int velicina;
    int obrok;
    JeloBaza jeloBaza;
    public JSONObject toJSON(){
        JSONObject jsonObject=new JSONObject();
        try{
            jsonObject.put("ime",ime);
            jsonObject.put("porcija",porcija);
            jsonObject.put("velicina",velicina);
            jsonObject.put("obrok", obrok);
            jsonObject.put("jeloBaza",jeloBaza.toJSON());
        }catch(JSONException e){
            e.printStackTrace();
        }
        return jsonObject;
    }
}

package com.viktorijanci.myapplication22;

import org.json.JSONException;
import org.json.JSONObject;

public class Podesavanja extends Korisnik {
    Korisnik lik;
    int cilj;
    int aktivan;
    int krajnji;
    int nedeljni;
    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("korisnik", lik.toJSON());
            jsonObject.put("cilj", cilj);
            jsonObject.put("aktivan", aktivan);
            jsonObject.put("krajnji", krajnji);
            jsonObject.put("nedeljni", nedeljni);
        }catch(JSONException e){
            e.printStackTrace();
        }
        return jsonObject;
    }
}

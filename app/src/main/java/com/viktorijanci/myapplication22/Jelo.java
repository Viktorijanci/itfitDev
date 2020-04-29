package com.viktorijanci.myapplication22;

import org.json.JSONException;
import org.json.JSONObject;

public class Jelo {
    String ime;
    int porcija;
    int velicina;
    int obrok;
    int thumb;
    JeloBaza jeloBaza;
    public Jelo(String ime, int porcija, int velicina, int obrok, int thumb){
        this.ime=ime;
        this.porcija=porcija;
        this.velicina=velicina;
        this.obrok=obrok;
        this.thumb=thumb;
    }
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
    public void importJeloBaza(){
        if (this.jeloBaza != null){
            this.ime = this.jeloBaza.getIme();
        }
    }
    public String getIme() {
        return this.ime;
    }
    public int getPorcija(){
        return this.porcija;
    }
    public int getVelicina(){
        return this.velicina;
    }
    public int getObrok(){
        return this.obrok;
    }
    public JeloBaza getJelo(){
        return this.jeloBaza;
    }
    public int getThumb(){
        return this.thumb;
    }
    public void setThumb(int thumb){
        this.thumb = thumb;
    }
}

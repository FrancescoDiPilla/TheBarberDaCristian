package com.example.thebarberdacristian;

import java.util.GregorianCalendar;

public class Messaggio {
    public String testo;
    public String data;

    public Messaggio(String _testo, String _data){
        testo=_testo;
        data=_data;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

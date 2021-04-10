package com.example.thebarberdacristian;

import java.util.ArrayList;

public class Ordine {
    public ArrayList<Prodotto> prodotti;
    public ArrayList<Integer> quantità;
    public String data;
    public double totale;
    String id;


    public Ordine(ArrayList<Prodotto> _prodotti,ArrayList<Integer> _uantità, String _data, double _totale,String _id) {
        prodotti = _prodotti;
        quantità=_uantità;
        data = _data;
        totale=_totale;
        id=_id;
    }

    public ArrayList<Prodotto> getProdotti() {
        return prodotti;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProdotti(ArrayList<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    public ArrayList<Integer> getQuantità() {
        return quantità;
    }

    public void setQuantità(ArrayList<Integer> quantità) {
        this.quantità = quantità;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }
}

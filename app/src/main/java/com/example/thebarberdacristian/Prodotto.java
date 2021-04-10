package com.example.thebarberdacristian;

import java.util.ArrayList;

public class Prodotto {
    public ArrayList<Integer> imgID;
    public String nome;
    public double price;


    public Prodotto(ArrayList ids, String _nome, double _price) {
        imgID = ids;
        nome = _nome;
        price = _price;
    }

    public ArrayList<Integer> getImgID() {
        return imgID;
    }

    public void setImgID(ArrayList<Integer> imgID) {
        this.imgID = imgID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

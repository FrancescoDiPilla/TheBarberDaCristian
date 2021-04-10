package com.example.thebarberdacristian;

import android.media.Image;

public class Appuntamento {
    public int imgID;
    public String data;
    boolean passato;

    public Appuntamento(int _img, String _data, boolean _passato){
        imgID =_img;
        data=_data;
        passato=_passato;
    }

    public int getImg() {
        return imgID;
    }

    public void setImg(int img) {
        this.imgID = img;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

package com.example.thebarberdacristian;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Appuntamenti extends AppCompatActivity {

    ListView lv;

    public static ArrayList<Appuntamento> al;


    Context context;
   public static  AppuntamentiAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_messaggi);
        lv=findViewById(R.id.listView);
        Appuntamento a1=new Appuntamento(R.drawable.ic_barba,"25/12/2020",true);
        Appuntamento a2=new Appuntamento(R.drawable.ic_capelli,"24/11/2020",true);
        Appuntamento a3=new Appuntamento(R.drawable.ic_entrambi,"27/10/2020",true);

        al= new ArrayList<Appuntamento>();
        al.add(a1);
        al.add(a2);
        al.add(a3);
        if(MainActivity.appuntamentoPrenotato!=null){
            al.add(0,MainActivity.appuntamentoPrenotato);
        }

        aa=new AppuntamentiAdapter(this,al);
        lv.setAdapter(aa);



    }
}

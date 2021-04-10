package com.example.thebarberdacristian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Ordini extends AppCompatActivity {

    ListView lv;
    OrdiniAdapter oa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(MainActivity.listaOrdini.size()>0){
        setContentView(R.layout.activity_ordini);
        lv=findViewById(R.id.lvOrdini);
        oa=new OrdiniAdapter(this,MainActivity.listaOrdini);
        lv.setAdapter(oa);}else{
            setContentView(R.layout.no_ordini);
        }


    }
}

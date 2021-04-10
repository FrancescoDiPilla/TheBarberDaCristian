package com.example.thebarberdacristian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Messaggi extends AppCompatActivity {

    ListView lv;
    MessaggiAdapter ma;
    public static ArrayList<Messaggio> al;
    String messaggioLungo1=" Buon Natale!Buon Natale!Buon Natale!Buon Natale!Buon Natale!Buon Natale!Buon Natale!Buon Natale!Buon Natale!Buon Natale!Buon Natale!Buon Natale!Buon Natale!Buon Natale!Buon Natale!Buon Natale!Buon Natale!Buon Natale!Buon Natale!";
    String messaggioLungo2="Buona Pasqua! Buona Pasqua!Buona Pasqua!Buona Pasqua!Buona Pasqua!Buona Pasqua!Buona Pasqua!Buona Pasqua!Buona Pasqua!Buona Pasqua!Buona Pasqua!Buona Pasqua!Buona Pasqua!Buona Pasqua!Buona Pasqua!Buona Pasqua!Buona Pasqua!Buona ";

    String messaggioLungo3="Vidal è scarso! Vidal è scarso!Vidal è scarso!Vidal è scarso!Vidal è scarso!Vidal è scarso!Vidal è scarso!Vidal è scarso!Vidal è scarso!Vidal è scarso!Vidal è scarso!Vidal è scarso!Vidal è scarso!Vidal è scarso!Vidal è scarso!Vidal è scarso!";
    String data1= "15/05/2020";
    String data3= "27/03/2020";
    String data2= "25/12/2020";
    Messaggio m1, m2,m3;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_messaggi);
        lv=findViewById(R.id.listView);
        al=new ArrayList<Messaggio>();
        m1= new Messaggio(messaggioLungo1,data1);
        m2= new Messaggio(messaggioLungo2,data2);
        m3= new Messaggio(messaggioLungo3,data3);
        al.add(m1);
        al.add(m2);
        al.add(m3);

        ma=new MessaggiAdapter(this,al);
        lv.setAdapter(ma);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Messaggio_dialog md = new Messaggio_dialog(context,position);
                md.show();
            }
        });

    }
}

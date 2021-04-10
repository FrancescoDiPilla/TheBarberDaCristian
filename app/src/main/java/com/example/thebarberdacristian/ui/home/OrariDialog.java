package com.example.thebarberdacristian.ui.home;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.thebarberdacristian.Appuntamento;
import com.example.thebarberdacristian.MainActivity;
import com.example.thebarberdacristian.OrariAdapter;
import com.example.thebarberdacristian.R;


public class OrariDialog extends Dialog {
    ListView listView;


    public OrariDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orari_layout);

        listView = findViewById(R.id.orariLV);
        listView.setAdapter(new OrariAdapter(getContext(), MainActivity.listadaMostrare));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.oraPrenotata = MainActivity.listadaMostrare.get(position).getOraInizio();
                MainActivity.minutPrenotata = MainActivity.listadaMostrare.get(position).getMinutiInizio();
                MainActivity.giaprenotatao=true;

                HomeFragment.tv.setText(HomeFragment.giornoSelezionato + " " +
                        MainActivity.listadaMostrare.get(position).getOraInizio() +
                        ":" + MainActivity.listadaMostrare.get(position).getMinutiInizio());

                Toast.makeText(getContext(),"Prenotazione effettuata!\nConsulta la sezione appuntamenti!",Toast.LENGTH_LONG).show();

                dismiss();

            }
        });
    }


}

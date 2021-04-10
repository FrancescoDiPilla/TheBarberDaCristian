package com.example.thebarberdacristian.ui.dashboard;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.thebarberdacristian.MainActivity;
import com.example.thebarberdacristian.Ordine;
import com.example.thebarberdacristian.R;
import com.example.thebarberdacristian.ui.home.HomeFragment;


public class ConfermaOrdineDialog extends Dialog {
    EditText q1, q2, q3, q4;
    Button c, a;


    public ConfermaOrdineDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conferma_ordine_dialog);


        q1 = findViewById(R.id.etProdotto1);
        q2 = findViewById(R.id.etProdotto2);
        q3 = findViewById(R.id.etProdotto3);
        q4 = findViewById(R.id.etProdotto4);

        c = findViewById(R.id.confermaOrdine);
        a = findViewById(R.id.annulla);

        q1.setText("" + DashboardFragment.carrello[0]);
        q2.setText("" + DashboardFragment.carrello[1]);
        q3.setText("" + DashboardFragment.carrello[2]);
        q4.setText("" + DashboardFragment.carrello[3]);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.quantitaProdotti.set(0, DashboardFragment.carrello[0]);
                MainActivity.quantitaProdotti.set(1, DashboardFragment.carrello[1]);
                MainActivity.quantitaProdotti.set(2, DashboardFragment.carrello[2]);
                MainActivity.quantitaProdotti.set(3, DashboardFragment.carrello[3]);

                double tot = (MainActivity.quantitaProdotti.get(0) * MainActivity.listatotaleProdotti.get(0).getPrice()) +
                        (MainActivity.quantitaProdotti.get(1) * MainActivity.listatotaleProdotti.get(1).getPrice())+
                        (MainActivity.quantitaProdotti.get(2)*MainActivity.listatotaleProdotti.get(2).getPrice())+
                        (MainActivity.quantitaProdotti.get(3)*MainActivity.listatotaleProdotti.get(3).getPrice());

                Ordine nuovoOrdine = new Ordine(MainActivity.listatotaleProdotti, MainActivity.quantitaProdotti, HomeFragment.sToday, tot,"dgdhfhfhf");
                MainActivity.listaOrdini.add(nuovoOrdine);
                Toast.makeText(getContext(),""+MainActivity.listaOrdini.size(),Toast.LENGTH_LONG).show();
                dismiss();
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}

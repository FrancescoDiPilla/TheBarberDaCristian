package com.example.thebarberdacristian.ui.home;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.thebarberdacristian.Appuntamento;
import com.example.thebarberdacristian.MainActivity;
import com.example.thebarberdacristian.R;


public class BarbaCapelliDialog extends Dialog {
    LinearLayout beard,hair,special,both;
    Button info;


    public BarbaCapelliDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barba_capelli_layout);

        beard=findViewById(R.id.beard);
        hair=findViewById(R.id.hair);
        special=findViewById(R.id.special);
        info=findViewById(R.id.info);
        both=findViewById(R.id.both);

        beard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appuntamento a =new Appuntamento(R.drawable.ic_barba,HomeFragment.s,false);
                MainActivity.appuntamentoPrenotato=a;
                MainActivity.durata=1;
                dismiss();
                OrariDialog od =new OrariDialog(getContext());
                od.show();
            }
        });
        hair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Appuntamento a =new Appuntamento(R.drawable.ic_capelli,HomeFragment.s,false);
                MainActivity.appuntamentoPrenotato=a;
                MainActivity.durata=1;
                dismiss();
                OrariDialog od =new OrariDialog(getContext());
                od.show();
            }
        });
        special.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appuntamento a =new Appuntamento(R.drawable.ic_pennello,HomeFragment.s,false);
                MainActivity.appuntamentoPrenotato=a;
                MainActivity.durata=3;

                dismiss();
                OrariDialog od =new OrariDialog(getContext());
                od.show();
            }
        });
        both.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Appuntamento a =new Appuntamento(R.drawable.ic_entrambi,HomeFragment.s,false);
                MainActivity.appuntamentoPrenotato=a;
                MainActivity.durata=2;

                dismiss();
                OrariDialog od =new OrariDialog(getContext());
                od.show();
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Decolorazione \n Black Mask \n Meches",Toast.LENGTH_LONG).show();
            }
        });
    }
}

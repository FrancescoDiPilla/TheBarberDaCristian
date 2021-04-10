package com.example.thebarberdacristian.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.thebarberdacristian.Appuntamenti;
import com.example.thebarberdacristian.Messaggi;
import com.example.thebarberdacristian.Ordini;
import com.example.thebarberdacristian.Profilo;
import com.example.thebarberdacristian.R;

public class NotificationsFragment extends Fragment {
LinearLayout prof,messa,appunta,ordi;
    View root;
    ConstraintLayout cl;
    ViewGroup cont;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        cont=container;
         root = inflater.inflate(R.layout.fragment_notifications, cont, false);
        prof=root.findViewById(R.id.prof);
        messa=root.findViewById(R.id.messa);
        appunta=root.findViewById(R.id.appunta);
        ordi=root.findViewById(R.id.ordi);
        cl=root.findViewById(R.id.notifictions);


        prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), Profilo.class);
                startActivity(i);
            }
        });

        messa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getContext(), Messaggi.class);
                startActivity(i);
            }
        });
        appunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getContext(), Appuntamenti.class);
                startActivity(i);
            }
        });

        ordi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), Ordini.class);
                startActivity(i);
              
            }
        });



        return root;
    }
}
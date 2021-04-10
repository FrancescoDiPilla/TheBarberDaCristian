package com.example.thebarberdacristian;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.thebarberdacristian.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class SignIn extends AppCompatActivity {

    FirebaseFirestore db;
    TextView nomecognome, nuovaemail, nuovapass, tel, giaregistrato;
    ConstraintLayout cL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

        setContentView(R.layout.activity_sign_in);
        cL=findViewById(R.id.cL);
        nomecognome = findViewById(R.id.NomeCognome);
        nuovaemail = findViewById(R.id.nuovaEmail);
        nuovapass = findViewById(R.id.nuovaPass);
        tel = findViewById(R.id.telefono);
        giaregistrato = findViewById(R.id.acced);

        //TODO CIFRARE PASSWORD

        db = FirebaseFirestore.getInstance();
        Button b = findViewById(R.id.btnSignin);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view =getLayoutInflater().inflate(R.layout.carica,null);
                cL.removeAllViews();
                cL.addView(view,cL.getWidth(),cL.getHeight());

                if (isInternetAvailable()) {


                    Map<String, Object> utente = new HashMap<>();
                    utente.put("Nome e Cognome", nomecognome.getText().toString());
                    utente.put("email", nuovaemail.getText().toString());
                    utente.put("password", nuovapass.getText().toString());
                    utente.put("tel", tel.getText().toString());



                    db.collection("utenti").document(nuovaemail.getText().toString())
                            .set(utente).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(), "Ti sei registrato con successso!", Toast.LENGTH_LONG).show();
                            Intent i =new Intent(SignIn.this,LogIn.class);
                            startActivity(i);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            View view1 =getLayoutInflater().inflate(R.layout.activity_sign_in,null);
                            cL.removeAllViews();
                            cL.addView(view1,cL.getWidth(),cL.getHeight());
                            Toast.makeText(getApplicationContext(), "Errore nella registrazione!", Toast.LENGTH_LONG).show();

                        }
                    });

                } else{
                    Toast.makeText(getApplicationContext(),"nessuna connessione",Toast.LENGTH_LONG).show();
                    view =getLayoutInflater().inflate(R.layout.activity_sign_in,null);
                    cL.removeAllViews();
                    cL.addView(view,cL.getWidth(),cL.getHeight());
                }
            }
        });


    }

    @Override
    public void onBackPressed() {

    }

    public boolean isInternetAvailable() {
        try {
            String command = "ping -c 1 google.com";
            return (Runtime.getRuntime().exec(command).waitFor() == 0);
        } catch (Exception e) {
            return false;
        }
    }
}

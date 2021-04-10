package com.example.thebarberdacristian;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.thebarberdacristian.R;
import com.google.firebase.firestore.FirebaseFirestore;

public class LogIn extends AppCompatActivity {

    EditText email, password;
    Button btnLogin;
    TextView resgistrati;
    CheckBox rb;
    ConstraintLayout cL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }
        setContentView(R.layout.activity_log_in);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnSignin);
        resgistrati = findViewById(R.id.registrati);
        rb = findViewById(R.id.rimanere);
        cL=findViewById(R.id.cL1);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(email.getText().toString().trim())) {
                    email.setError("Inserisci l'email");
                } else if ((TextUtils.isEmpty(password.getText().toString().trim())) || (password.getText().toString().length() < 6)) {
                    password.setError("Inserisci la password di almeno 6 caratteri");
                } else {
                    View view =getLayoutInflater().inflate(R.layout.carica,null);
                    cL.removeAllViews();
                    cL.addView(view,cL.getWidth(),cL.getHeight());
                    if (isInternetAvailable()) {
                        //TODO controllo credenziali

                        Intent i = new Intent(LogIn.this, MainActivity.class);
                        startActivity(i);


                        if(rb.isChecked()){
                            //TODO salva credenziali
                        }
                        MainActivity.user=email.getText().toString();
                        String nospazio= email.getText().toString().replaceAll(" ","");
                        MainActivity.email=nospazio+"@gmail.com";
                        finish();
                    } else {
                        Toast.makeText(LogIn.this, "Nessuna Connessione", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });



        resgistrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LogIn.this, SignIn.class);
                startActivity(i);
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
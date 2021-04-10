package com.example.thebarberdacristian.ui.notifications;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.thebarberdacristian.MainActivity;
import com.example.thebarberdacristian.R;


public class ProfiloDialog extends Dialog {
    EditText email,tel,user;
    Button conferma,annulla;


    public ProfiloDialog(@NonNull Context context) {
        super(context,R.style.full_screen_dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        setContentView(R.layout.profilo_dialog);
        email=findViewById(R.id.etEmail);
        tel=findViewById(R.id.etTel);
        user=findViewById(R.id.etUser);
        conferma=findViewById(R.id.confermaMoodifiche);
        annulla=findViewById(R.id.annullamodifiche);

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        annulla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        email.setText(MainActivity.email);
        tel.setText(""+MainActivity.tel);
        user.setText(MainActivity.user);

    }
}

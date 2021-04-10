package com.example.thebarberdacristian;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class Messaggio_dialog extends Dialog {
    public Messaggio_dialog(@NonNull Context context,int _position) {
        super(context);
        position=_position;
    }
    int position;
    TextView tv,tv1;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messaggio_layout);
        tv=findViewById(R.id.messaggioAperto);
        tv1=findViewById(R.id.dataMess);
        tv1.setText(Messaggi.al.get(position).getData());
        tv.setMovementMethod(new ScrollingMovementMethod());
        tv.setText(Messaggi.al.get(position).getTesto());

        ok=findViewById(R.id.OK);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
dismiss();            }
        });
    }
}

package com.example.thebarberdacristian;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Profilo extends AppCompatActivity {

    EditText tel,email,user;
    Button c,a;
    AlertDialog.Builder adb;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilo_dialog);
        context =this;

        tel=findViewById(R.id.etTel);
        email=findViewById(R.id.etEmail);
        user=findViewById(R.id.etUser);
        c=findViewById(R.id.confermaMoodifiche);
        a=findViewById(R.id.annullamodifiche);

        tel.setText(""+MainActivity.tel);
        email.setText(""+MainActivity.email);
        user.setText(""+MainActivity.user);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(tel.getText().toString().contentEquals(""+MainActivity.tel))&&
                        (!(user.getText().toString().contentEquals(MainActivity.user)))&&
                        (!(email.getText().toString().contentEquals(""+MainActivity.email)))){
                   // Toast.makeText(getApplicationContext(),"hai modificato tutto",Toast.LENGTH_LONG).show();
                    new AlertDialog.Builder(context)
                            .setTitle("Confermare le modifiche")
                            .setMessage("Modificare tutti i campi?")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    MainActivity.tel=Integer.parseInt(tel.getText().toString());
                                    MainActivity.email=email.getText().toString();
                                    MainActivity.user=user.getText().toString();
                                    finish();
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();
                //tutti

                }else if(!(tel.getText().toString().contentEquals(""+MainActivity.tel))&&
                        (!(user.getText().toString().contentEquals(MainActivity.user)))&&
                        ((email.getText().toString().contentEquals(""+MainActivity.email)))) {
                  //  Toast.makeText(getApplicationContext(), "hai modificato tel e user", Toast.LENGTH_LONG).show();
                    new AlertDialog.Builder(context)
                            .setTitle("Confermare le modifiche")
                            .setMessage("Modificare tel e user?")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    MainActivity.tel=Integer.parseInt(tel.getText().toString());
                                    MainActivity.user=user.getText().toString();
                                    finish();
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();
                    //tel e user
                }else if(!(tel.getText().toString().contentEquals(""+MainActivity.tel))&&
                        ((user.getText().toString().contentEquals(MainActivity.user)))&&
                        (!(email.getText().toString().contentEquals(""+MainActivity.email)))) {
                    //Toast.makeText(getApplicationContext(), "hai modificato tel e email", Toast.LENGTH_LONG).show();
                    new AlertDialog.Builder(context)
                            .setTitle("Confermare le modifiche")
                            .setMessage("Modificare tel e email?")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    MainActivity.tel=Integer.parseInt(tel.getText().toString());
                                    MainActivity.email=email.getText().toString();

                                    finish();
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();
                    //tel email
                }else if((tel.getText().toString().contentEquals(""+MainActivity.tel))&&
                        (!(user.getText().toString().contentEquals(MainActivity.user)))&&
                        (!(email.getText().toString().contentEquals(""+MainActivity.email)))) {
                   // Toast.makeText(getApplicationContext(), "hai modificato user e email", Toast.LENGTH_LONG).show();
                    new AlertDialog.Builder(context)
                            .setTitle("Confermare le modifiche")
                            .setMessage("Modificare user e email?")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    MainActivity.email=email.getText().toString();
                                    MainActivity.user=user.getText().toString();
                                    finish();
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();
                    //user e email
                }else if((tel.getText().toString().contentEquals(""+MainActivity.tel))&&
                        ((user.getText().toString().contentEquals(MainActivity.user)))&&
                        (!(email.getText().toString().contentEquals(""+MainActivity.email)))) {
                    //Toast.makeText(getApplicationContext(), "hai modificato email", Toast.LENGTH_LONG).show();
                    new AlertDialog.Builder(context)
                            .setTitle("Confermare le modifiche")
                            .setMessage("Modificare email?")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    MainActivity.email=email.getText().toString();

                                    finish();
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();
                    // email
                } else if((tel.getText().toString().contentEquals(""+MainActivity.tel))&&
                        (!(user.getText().toString().contentEquals(MainActivity.user)))&&
                        ((email.getText().toString().contentEquals(""+MainActivity.email)))) {
                   // Toast.makeText(getApplicationContext(), "hai modificato user ", Toast.LENGTH_LONG).show();
                    new AlertDialog.Builder(context)
                            .setTitle("Confermare le modifiche")
                            .setMessage("Modificare user?")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    MainActivity.user=user.getText().toString();
                                    finish();
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();
                    //user
                } else if(!(tel.getText().toString().contentEquals(""+MainActivity.tel))&&
                        ((user.getText().toString().contentEquals(MainActivity.user)))&&
                        ((email.getText().toString().contentEquals(""+MainActivity.email)))) {
                    //Toast.makeText(getApplicationContext(), "hai modificato tel", Toast.LENGTH_LONG).show();
                    new AlertDialog.Builder(context)
                            .setTitle("Confermare le modifiche")
                            .setMessage("Modificare tel?")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    MainActivity.tel=Integer.parseInt(tel.getText().toString());

                                    finish();
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();
                    //tel
                }else {
                    finish();
                }
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

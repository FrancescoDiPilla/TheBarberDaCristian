package com.example.thebarberdacristian;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AppuntamentiAdapter extends BaseAdapter {

    public ArrayList<Appuntamento> listaAppuntamenti;
    public LayoutInflater layoutInflater;
    public static Context context;

    public AppuntamentiAdapter(Context ctx, ArrayList<Appuntamento> appuntamenti) {
        this.context = ctx;
        this.listaAppuntamenti = appuntamenti;
        this.layoutInflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return listaAppuntamenti.size();
    }

    @Override
    public Object getItem(int position) {
        return listaAppuntamenti.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.myitem2, parent, false);

                holder = new ViewHolder();
                holder.imgView = (ImageView) convertView.findViewById(R.id.immagineAppuntamento);
                holder.data = (TextView) convertView.findViewById(R.id.dataAppuntamento);
                holder.canc=(ImageButton) convertView.findViewById(R.id.canc);
                convertView.setTag(holder);
            } else {

                holder = (ViewHolder) convertView.getTag();
            }

        Appuntamento a = this.listaAppuntamenti.get(position);
        holder.imgView.setImageResource(a.getImg());
        holder.data.setText(a.getData());
        if(!listaAppuntamenti.get(position).passato){
            holder.canc.setVisibility(View.VISIBLE);
            holder.canc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    new AlertDialog.Builder(context)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("Vuoi annullare questo appuntamento?")
                            .setPositiveButton("Sì", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Appuntamenti.al.remove(position);
                                    Appuntamenti.aa.notifyDataSetChanged();
                                    holder.canc.setVisibility(View.INVISIBLE);
                                    Toast.makeText(context,"Appuntamento annullato",Toast.LENGTH_LONG).show();
                                    MainActivity.appuntamentoPrenotato=null;
                                    MainActivity.listadaMostrare=MainActivity.listatotaleOrari;
                                    MainActivity.minutPrenotata=0;
                                    MainActivity.oraPrenotata=0;
                                    MainActivity.giaprenotatao=false;

                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .show();

                }
            });
        }
        return convertView;
    }

    static class ViewHolder {
        ImageView imgView;
        TextView data;
        ImageButton canc;
    }
}


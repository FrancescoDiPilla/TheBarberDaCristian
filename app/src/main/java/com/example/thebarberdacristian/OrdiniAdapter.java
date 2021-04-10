package com.example.thebarberdacristian;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class OrdiniAdapter extends BaseAdapter {

    public ArrayList<Ordine> listaOrdini;
    public LayoutInflater layoutInflater;
    public static Context context;

    public OrdiniAdapter(Context ctx, ArrayList<Ordine> _ordini) {
        this.context = ctx;
        this.listaOrdini = _ordini;
        this.layoutInflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return listaOrdini.size();
    }

    @Override
    public Object getItem(int position) {
        return listaOrdini.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.myitem4, parent, false);
            holder = new ViewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.idordine);
            holder.data = (TextView) convertView.findViewById(R.id.dataordine);
            holder.ordLayout = (LinearLayout) convertView.findViewById(R.id.ordLayout);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Ordine ord = this.listaOrdini.get(position);
        holder.id.setText(ord.getId());
        holder.data.setText(ord.getData());
        holder.ordLayout.setTag(ord);
        holder.ordLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.ord = (Ordine) holder.ordLayout.getTag();
                String message = MainActivity.ord.getId() + "\n" + MainActivity.ord.getData() + "\n" + MainActivity.ord.getProdotti().get(0).nome + "\n";
                new AlertDialog.Builder(context)
                        .setTitle("Confermare le modifiche")
                        .setMessage(message)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
            }
        });
        return convertView;
    }

    public static class ViewHolder {
        TextView id;
        TextView data;
        LinearLayout ordLayout;
    }
}


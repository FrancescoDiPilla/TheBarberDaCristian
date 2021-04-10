package com.example.thebarberdacristian;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class OrariAdapter extends BaseAdapter {

    public ArrayList<Intervallo> listaOrari;
    public LayoutInflater layoutInflater;
    public static Context context;

    public OrariAdapter(Context ctx, ArrayList<Intervallo> _orari) {
        this.context = ctx;
        this.listaOrari = _orari;
        this.layoutInflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return listaOrari.size();
    }

    @Override
    public Object getItem(int position) {
        return listaOrari.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.myitem3, parent, false);
                holder = new ViewHolder();
                holder.orario = (TextView) convertView.findViewById(R.id.tvorario);
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }

        Intervallo i = this.listaOrari.get(position);
            if(i.getMinutiInizio()==0) {
                holder.orario.setText(i.getOraInizio() + ":" + i.getMinutiInizio() + "0");
            }else{
                holder.orario.setText(i.getOraInizio() + ":" + i.getMinutiInizio());
            }
            if(i.isPrenotato()){
                holder.orario.setBackgroundResource( R.drawable.cardshape);
                holder.orario.setTextColor(Color.BLACK);
            }
        return convertView;
    }

    public static class ViewHolder {
        TextView orario;
    }
}


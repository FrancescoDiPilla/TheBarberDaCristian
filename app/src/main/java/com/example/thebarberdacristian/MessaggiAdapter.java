package com.example.thebarberdacristian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



import java.util.ArrayList;

public class MessaggiAdapter extends BaseAdapter {

    public ArrayList<Messaggio> listaMessaggi;
    public LayoutInflater layoutInflater;
    public static Context context;

    public MessaggiAdapter(Context ctx, ArrayList<Messaggio> _messaggi) {
        this.context = ctx;
        this.listaMessaggi = _messaggi;
        this.layoutInflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return listaMessaggi.size();
    }

    @Override
    public Object getItem(int position) {
        return listaMessaggi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.myitem, parent, false);

                holder = new ViewHolder();
                holder.testo = (TextView) convertView.findViewById(R.id.testoMessaggio);
                holder.data = (TextView) convertView.findViewById(R.id.dataMesaggio);
                convertView.setTag(holder);
            } else {

                holder = (ViewHolder) convertView.getTag();
            }

        Messaggio m = this.listaMessaggi.get(position);
        holder.testo.setText(m.getTesto());
        holder.data.setText(m.getData());
        return convertView;
    }

    static class ViewHolder {
        TextView testo;
        TextView data;
    }
}


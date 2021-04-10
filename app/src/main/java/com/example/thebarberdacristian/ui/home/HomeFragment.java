package com.example.thebarberdacristian.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.thebarberdacristian.MainActivity;
import com.example.thebarberdacristian.R;

import java.util.GregorianCalendar;


public class HomeFragment extends Fragment {

    public static TextView tv;
    private CalendarView calendarView;
    private boolean internetAvailable = false;


    public static String giornoSettimana = "";
    public static String s;
    BarbaCapelliDialog bcd;


    private GregorianCalendar today = new GregorianCalendar();
    public static String sToday;

    GregorianCalendar selezionato;
    public static String giornoSelezionato;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        sToday = "" + today.get(GregorianCalendar.DAY_OF_MONTH) + "/" + today.get(GregorianCalendar.MONTH) + "/" + today.get(GregorianCalendar.YEAR);
        tv = root.findViewById(R.id.prenotazioni);

        if (MainActivity.appuntamentoPrenotato != null) {
            if (MainActivity.oraPrenotata != 0) {
                tv.setText(MainActivity.giornoSettimana + "  " + MainActivity.appuntamentoPrenotato.getData() + " " + MainActivity.oraPrenotata + ":" + MainActivity.minutPrenotata);

            } else {
                tv.setText(MainActivity.giornoSettimana + "  " + MainActivity.appuntamentoPrenotato.getData() + " " + MainActivity.oraPrenotata + ":" + MainActivity.minutPrenotata + "0");

            }
        }


        calendarView = root.findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                GregorianCalendar selected = new GregorianCalendar(year, month, dayOfMonth);
                internetAvailable = isInternetAvailable();
                int meseEffettivo = selected.get(GregorianCalendar.MONTH) + 1;
                scriviGiorno(selected);

                if ((MainActivity.giornoSettimana.contentEquals("DOM")) || (MainActivity.giornoSettimana.contentEquals("LUN"))) {
                    Toast.makeText(getContext(), "Il salone è chiuso in questa giornata!", Toast.LENGTH_LONG).show();
                } else if (internetAvailable) {

                    if ((selected.compareTo(today) >= 0) || (
                            (selected.get(GregorianCalendar.YEAR) == today.get(GregorianCalendar.YEAR)) &&
                                    (selected.get(GregorianCalendar.MONTH) == today.get(GregorianCalendar.MONTH)) &&
                                    (selected.get(GregorianCalendar.DAY_OF_MONTH) == today.get(GregorianCalendar.DAY_OF_MONTH)))) {

                        if (!MainActivity.giaprenotatao) {
                            selezionato = selected;
                            giornoSelezionato = giornoSettimana + "  " + selected.get(GregorianCalendar.DAY_OF_MONTH) + "/"
                                    + meseEffettivo + "/"
                                    + selected.get(GregorianCalendar.YEAR);


                            s = selected.get(GregorianCalendar.DAY_OF_MONTH) + "/"
                                    + meseEffettivo + "/"
                                    + selected.get(GregorianCalendar.YEAR);
                            bcd = new BarbaCapelliDialog(getContext());
                            bcd.show();


                        } else {
                            Toast.makeText(getContext(), "Hai già prenotato!", Toast.LENGTH_LONG).show();
                        }

                    }

                } else {
                    Toast.makeText(getContext(), "Nessuna Connessione!", Toast.LENGTH_LONG).show();
                }

            }
        });

        return root;
    }


    public boolean isInternetAvailable() {
        try {
            String command = "ping -c 1 google.com";
            return (Runtime.getRuntime().exec(command).waitFor() == 0);
        } catch (Exception e) {
            return false;
        }
    }


    public void scriviGiorno(GregorianCalendar selected) {
        System.out.println(selected.get(GregorianCalendar.YEAR));
        System.out.println(selected.get(GregorianCalendar.MONTH));
        System.out.println(selected.get(GregorianCalendar.DAY_OF_MONTH));

        switch (selected.get(GregorianCalendar.DAY_OF_WEEK)) {
            case 1:
                MainActivity.giornoSettimana = "DOM";
                giornoSettimana = "DOM";
                break;
            case 2:
                MainActivity.giornoSettimana = "LUN";
                giornoSettimana = "LUN";
                break;
            case 3:
                MainActivity.giornoSettimana = "MAR";
                giornoSettimana = "MAR";
                break;
            case 4:
                MainActivity.giornoSettimana = "MER";
                giornoSettimana = "MER";
                break;
            case 5:
                MainActivity.giornoSettimana = "GIO";
                giornoSettimana = "GIO";
                break;
            case 6:
                MainActivity.giornoSettimana = "VEN";
                giornoSettimana = "VEN";
                break;
            case 7:
                MainActivity.giornoSettimana = "SAB";
                giornoSettimana = "SAB";
                break;
        }
        System.out.println("giorno " + giornoSettimana);

    }

    @Override
    public void onResume() {
        super.onResume();
        if ((MainActivity.appuntamentoPrenotato != null) && (!MainActivity.giornoSettimana.contentEquals(""))) {
            tv.setText(MainActivity.giornoSettimana + "  " + MainActivity.appuntamentoPrenotato.getData() + " " + MainActivity.oraPrenotata + ":" + MainActivity.minutPrenotata);
        }
    }
}
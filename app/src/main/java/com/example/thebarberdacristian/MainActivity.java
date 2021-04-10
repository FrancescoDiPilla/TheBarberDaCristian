package com.example.thebarberdacristian;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.thebarberdacristian.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String user = "mario rossi";
    public static int tel=36464748;
    public static  String email="m.rossi@gmail.com";
    public static Appuntamento appuntamentoPrenotato= null;
    public static String giornoSettimana="";
    public static ArrayList<Intervallo> listatotaleOrari=new ArrayList<Intervallo>();
    public static ArrayList<Intervallo> listadaMostrare=new ArrayList<Intervallo>();
    public static int oraPrenotata;
    public static int minutPrenotata;
    public static int durata;
    public static ArrayList<Prodotto> listatotaleProdotti=new ArrayList<Prodotto>();
    public static ArrayList<Integer> imgProdotto1=new ArrayList<Integer>();
    public static ArrayList<Integer> imgProdotto2=new ArrayList<Integer>();
    public static ArrayList<Integer> imgProdotto3=new ArrayList<Integer>();
    public static ArrayList<Integer> imgProdotto4=new ArrayList<Integer>();
    public static ArrayList<Integer> quantitaProdotti=new ArrayList<Integer>();
    public static Ordine ord;
    public static boolean giaprenotatao = false;

    public static ArrayList<Ordine> listaOrdini= new ArrayList<Ordine>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        inizializzaListaOrari();
        inizializzaProdotti();

    }


    @Override
    public void onBackPressed() {

    }

    public void inizializzaListaOrari(){
        for (int i=8; i<20; i++){
            if((i!=13)&&(i!=14)) {
                for (int j = 0; j < 60; j = j + 20) {
                    int start=listatotaleOrari.size();
                    Intervallo inte = new Intervallo(i, j, false, null);
                    listatotaleOrari.add(inte);
                }
            }
        }
        listadaMostrare=listatotaleOrari;
    }

    public void inizializzaProdotti(){

        quantitaProdotti.add(0);
        quantitaProdotti.add(0);
        quantitaProdotti.add(0);
        quantitaProdotti.add(0);

        imgProdotto1.add(R.drawable.cera4);
        imgProdotto2.add(R.drawable.cera1);
        imgProdotto3.add(R.drawable.cera7);
        imgProdotto4.add(R.drawable.cera10);

        Prodotto p1=new Prodotto(imgProdotto1,"prodotto 1",23.00);
        Prodotto p2=new Prodotto(imgProdotto2,"prodotto 2",43.00);
        Prodotto p3=new Prodotto(imgProdotto3,"prodotto 3",26.00);
        Prodotto p4=new Prodotto(imgProdotto4,"prodotto 4",19.00);

        listatotaleProdotti.add(p1);
        listatotaleProdotti.add(p2);
        listatotaleProdotti.add(p3);
        listatotaleProdotti.add(p4);

    }
}
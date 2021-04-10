package com.example.thebarberdacristian.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;


import com.example.thebarberdacristian.R;


public class DashboardFragment extends Fragment {

    private int[] images1 = new int[]{R.drawable.cera4, R.drawable.cera5, R.drawable.cera6};

    private int[] images2 = new int[]{R.drawable.cera1, R.drawable.cera2, R.drawable.cera3};
    private int[] images3 = new int[]{R.drawable.cera7, R.drawable.cera8, R.drawable.cera9};
    private int[] images4 = new int[]{R.drawable.cera10, R.drawable.cera11, R.drawable.cera12};
    private Button meno1, meno2, meno3, meno4, piu1, piu2, piu3, piu4,conferma;
    private TextView q1, q2, q3, q4;
    private static final int numProdotti = 4;

    public static int[] carrello = new int[]{0, 0, 0, 0};
    View root;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        inizializzaComponenti();
        azzera();
        return root;


    }


    public void inizializzaComponenti() {

        conferma=root.findViewById(R.id.completa);

        q1 = root.findViewById(R.id.quantità1);
        q2 = root.findViewById(R.id.quantità2);
        q3 = root.findViewById(R.id.quantità3);
        q4 = root.findViewById(R.id.quantità4);

        q1.setText(""+carrello[0]);
        q2.setText(""+carrello[0]);
        q3.setText(""+carrello[0]);
        q4.setText(""+carrello[0]);

        meno1 = root.findViewById(R.id.meno1);
        meno2 = root.findViewById(R.id.meno2);
        meno3 = root.findViewById(R.id.meno3);
        meno4 = root.findViewById(R.id.meno4);


        meno2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(carrello[1] == 0)) {
                    carrello[1] = carrello[1] - 1;
                    q2.setText(""+carrello[1]);
                    if((carrello[0]==0)&&(carrello[1]==0)&&(carrello[2]==0)&&(carrello[3]==0)){
                        conferma.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        meno3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(carrello[2] == 0)) {
                    carrello[2] = carrello[2] - 1;
                    q3.setText(""+carrello[2]);
                    if((carrello[0]==0)&&(carrello[1]==0)&&(carrello[2]==0)&&(carrello[3]==0)){
                        conferma.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        meno4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(carrello[3] == 0)) {
                    carrello[3] = carrello[3] - 1;
                    q4.setText(""+carrello[3]);
                    if((carrello[0]==0)&&(carrello[1]==0)&&(carrello[2]==0)&&(carrello[3]==0)){
                        conferma.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        meno1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(carrello[0] == 0)) {
                    carrello[0] = carrello[0] - 1;
                    q1.setText(""+carrello[0]);
                    if((carrello[0]==0)&&(carrello[1]==0)&&(carrello[2]==0)&&(carrello[3]==0)){
                        conferma.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        piu1 = root.findViewById(R.id.piu1);
        piu2 = root.findViewById(R.id.piu2);
        piu3 = root.findViewById(R.id.piu3);
        piu4 = root.findViewById(R.id.piu4);


        piu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carrello[0]=carrello[0]+1;
                String s =""+(carrello[0]);
                q1.setText(s);
                conferma.setVisibility(View.VISIBLE);

            }
        });

        piu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carrello[1]=carrello[1]+1;
                String s =""+(carrello[1]);
                q2.setText(s);
                conferma.setVisibility(View.VISIBLE);

            }
        });

        piu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carrello[2]=carrello[2]+1;
                String s =""+(carrello[2]);
                q3.setText(s);
                conferma.setVisibility(View.VISIBLE);

            }
        });

        piu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carrello[3]=carrello[3]+1;
                String s =""+(carrello[3]);
                q4.setText(s);
                conferma.setVisibility(View.VISIBLE);

            }
        });

        ImageAdpter imageAdpter = new ImageAdpter(getContext(), images1);
        ImageAdpter imageAdpter2 = new ImageAdpter(getContext(), images2);
        ImageAdpter imageAdpter3 = new ImageAdpter(getContext(), images3);
        ImageAdpter imageAdpter4 = new ImageAdpter(getContext(), images4);


        ViewPager viewPager2 = root.findViewById(R.id.viewPager2);
        ViewPager viewPager3 = root.findViewById(R.id.viewPager3);
        ViewPager viewPager4 = root.findViewById(R.id.viewPager4);
        ViewPager viewPager5 = root.findViewById(R.id.viewPager5);
        viewPager2.setAdapter(imageAdpter);
        viewPager3.setAdapter(imageAdpter2);
        viewPager4.setAdapter(imageAdpter3);
        viewPager5.setAdapter(imageAdpter4);

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfermaOrdineDialog cod=new ConfermaOrdineDialog(getContext());
                cod.show();
            }
        });
    }

    public void azzera(){
        carrello[0]=0;
        carrello[1]=0;
        carrello[2]=0;
        carrello[3]=0;

        q1.setText("0");
        q2.setText("0");
        q3.setText("0");
        q4.setText("0");
    }
}
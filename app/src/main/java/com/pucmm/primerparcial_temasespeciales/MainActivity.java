package com.pucmm.primerparcial_temasespeciales;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static int posicion2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        posicion2 = getResources().getConfiguration().orientation;
        MuestraFragment muestraFragment = new MuestraFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.mainLayout, muestraFragment).commit();
    }
    @Override
    protected void onResume() {
        super.onResume();
        posicion2 = getResources().getConfiguration().orientation;
    }

}
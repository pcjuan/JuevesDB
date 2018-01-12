package com.example.roman.juevesdb;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Verfificar en los Fragmentos creados la version del fragmento V4 o standar
    //para no tener problemas de compatibilidad
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Fragment fragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    cargaFragmentMascotas();
                    return true;
                case R.id.navigation_dashboard:
                    cargaFragmentNuevaMascota();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        cargaFragmentMascotas();
    }


    public void cargaFragmentMascotas(){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        fragment = new MascotasFragment();
        ft.replace(R.id.contenedor, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }
    public void cargaFragmentNuevaMascota(){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        fragment = new NuevaMascotaFragment();
        ft.replace(R.id.contenedor, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }



}

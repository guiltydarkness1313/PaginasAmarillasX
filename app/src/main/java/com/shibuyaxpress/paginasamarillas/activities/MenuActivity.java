package com.shibuyaxpress.paginasamarillas.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.shibuyaxpress.paginasamarillas.models.BottomNavigationViewHelper;
import com.shibuyaxpress.paginasamarillas.R;
import com.shibuyaxpress.paginasamarillas.fragments.ARFragment;
import com.shibuyaxpress.paginasamarillas.fragments.ConfigurationFragment;
import com.shibuyaxpress.paginasamarillas.fragments.EncontrarFragment;
import com.shibuyaxpress.paginasamarillas.fragments.LocationFragment;

public class MenuActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //fragment por defecto
        MostrarPantallaSeleccionada(R.id.navigation_find);


    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            MostrarPantallaSeleccionada(item.getItemId());
            return true;
        }};

        private void MostrarPantallaSeleccionada(int Itemid) {
            //control de fragments

            //creacion de variable tipo Fragment
            Fragment fragment = null;

            //iniciar los fragmentos
            switch (Itemid) {
                case R.id.navigation_find:
                    fragment = new EncontrarFragment();
                    break;
                case R.id.navigation_location:
                    fragment = new LocationFragment();
                    break;
                case R.id.navigation_configurations:
                    fragment = new ConfigurationFragment();
                    break;
                case R.id.navigation_AR:
                    fragment = new ARFragment();
                    break;
            }

            //reemplazamiento de fragments
            if (fragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, fragment);
                transaction.commit();
            }
        }

        /////////////////////////
}
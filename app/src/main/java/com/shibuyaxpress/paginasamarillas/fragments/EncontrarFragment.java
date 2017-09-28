package com.shibuyaxpress.paginasamarillas.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.shibuyaxpress.paginasamarillas.Busqueda;
import com.shibuyaxpress.paginasamarillas.R;
import com.shibuyaxpress.paginasamarillas.ResultadoActivity;
import com.shibuyaxpress.paginasamarillas.TabResultadoFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class EncontrarFragment extends Fragment {

    EditText busqueda;
    ImageButton btnbusqueda;

    public EncontrarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_encontrar, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        busqueda = view.findViewById(R.id.editext_busqueda);
        btnbusqueda=view.findViewById(R.id.btn_search);

        btnbusqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RealizarBusqueda();
            }
        });
    }

    public void RealizarBusqueda(){
        Intent launcher=new Intent(getContext(),ResultadoActivity.class);
        String texto=busqueda.getText().toString();
        launcher.putExtra("keywords",texto);
        startActivity(launcher);
        //////////////////
        Busqueda.getInstance().setKey(texto);

    }

}

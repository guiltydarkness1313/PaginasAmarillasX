package com.shibuyaxpress.paginasamarillas.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shibuyaxpress.paginasamarillas.R;
import com.shibuyaxpress.paginasamarillas.adapters.RecyclerViewAdapter;
import com.shibuyaxpress.paginasamarillas.models.Busqueda;
import com.shibuyaxpress.paginasamarillas.models.Empresa;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabResultadoFragment extends Fragment {

    private ArrayList<Empresa> lista, aux;
    private LinearLayoutManager manager;
    private TextView resultado;

    public TabResultadoFragment() {
        // Required empty public constructor
    }

    Bundle args = getArguments();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_tab_resultado, container, false);
        final View view = inflater.inflate(R.layout.fragment_tab_resultado, container, false);

        List<Empresa> rowListItem = getData();
        manager = new LinearLayoutManager(getActivity());
        //recycler
        RecyclerView reciclador = (RecyclerView) view.findViewById(R.id.reciclador_resultados);

        resultado = view.findViewById(R.id.txt_resultado);

        reciclador.setHasFixedSize(true);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), rowListItem);
        reciclador.setLayoutManager(manager);
        reciclador.setAdapter(adapter);
        //resultado.setText("se ha encontrado"+"resultados");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


    //int id, String rubro, String nombre, String direccion, String telefono, String correo, String url, int logo, String info
    public List<Empresa> getData() {
        lista = new ArrayList<Empresa>();
        aux = new ArrayList<Empresa>();
        Empresa emp = new Empresa(1, "restaurantes", "KFC", "Av. Canada 312", "505-0505", "kfc@kfc.com", "www.kfc.com", "https://upload.wikimedia.org/wikipedia/en/thumb/b/bf/KFC_logo.svg/1024px-KFC_logo.svg.png", "Restaurante de comida rapida.exe");
        lista.add(emp);
        emp = new Empresa(2, "restaurantes", "Pizza Hut", "Av. Aviación 352", "505-1111", "pizzahut@pac.com", "www.pizzahut.com", "https://upload.wikimedia.org/wikipedia/en/thumb/d/d2/Pizza_Hut_logo.svg/1088px-Pizza_Hut_logo.svg.png", "Restaurante de comida rapida.exe");
        lista.add(emp);
        emp = new Empresa(3, "restaurantes", "Chifa XUNFAN", "Av. del Aire 122", "871-8115", "chifaxunfan@gmail.com", "www.chifaxunfan.com", "https://www.piscotrail.com/sf/media/2011/01/chifa.png", "Restaurante de comida oriental.exe");
        lista.add(emp);
        emp = new Empresa(4, "Restaurantes", "El buen sabor", "Av. Benavides 522", "212-8115", "elbuesa@gmail.com", "www.elbuensabor.com", "http://www.elbuensaborperu.com/images/imagen1.jpg", "Restaurante de comida peruana");
        lista.add(emp);
        emp = new Empresa(5, "Restaurantes", "La Romana", "Av. San borja norte 522", "255-8115", "romana@gmail.com", "www.laromana.com", "https://3.bp.blogspot.com/-rAxbci6-cM4/WE7ZppGVe4I/AAAAAAAA3fY/TkiySUlQJTgR7xkOXViJ1IjFRjOulFWnwCLcB/s1600/pizzeria-la-romana2.jpg", "Restaurante de comida italiana");
        lista.add(emp);
        int contador=0;
        String key = Busqueda.getInstance().getKey();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getRubro().equalsIgnoreCase(key)||lista.get(i).getRubro().toLowerCase().contains(key.toLowerCase())) {
                aux.add(lista.get(i));
            }else {
                if (lista.get(i).getNombre().equalsIgnoreCase(key)||lista.get(i).getNombre().toLowerCase().contains(key.toLowerCase())) {
                    aux.add(lista.get(i));
                    break;
                }else {

                }
            }

            }
            return aux;
        }
    }





package com.shibuyaxpress.paginasamarillas.holders;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shibuyaxpress.paginasamarillas.R;
import com.shibuyaxpress.paginasamarillas.activities.DetallesActivity;
import com.shibuyaxpress.paginasamarillas.models.Empresa;

/**
 * Created by paulf on 28-Sep-17.
 */

public class RecyclerViewHolders extends RecyclerView.ViewHolder {

    public TextView nombreEmpresa;
    public ImageView imagenEmpresa;
    public TextView direccionEmpresa;
    public TextView telefonoEmpresa;
    public TextView txtresultado;
    public View root;
    public RecyclerViewHolders(View itemView) {
        super(itemView);
        //realizar un lcicc
        direccionEmpresa = (TextView)itemView.findViewById(R.id.txt_direccion);
        telefonoEmpresa = (TextView) itemView.findViewById(R.id.txt_telefono);
        imagenEmpresa=(ImageView)itemView.findViewById(R.id.img_empresa);
        nombreEmpresa=(TextView)itemView.findViewById(R.id.txt_nombre);
        txtresultado=(TextView)itemView.findViewById(R.id.txt_resultado);
        root=itemView;
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //seteo de datos clickeado
                Empresa emp=(Empresa)v.getTag();
                Intent launcher=new Intent(v.getContext(),DetallesActivity.class);
                launcher.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //int id, String rubro, String nombre, String direccion, String telefono, String correo, String url, String logo, String info
                launcher.putExtra("nombre",emp.getNombre());
                launcher.putExtra("imagen",emp.getLogo());
                launcher.putExtra("info",emp.getInfo());
                launcher.putExtra("telefono",emp.getTelefono());
                launcher.putExtra("direccion",emp.getDireccion());
                launcher.putExtra("url",emp.getUrl());
                launcher.putExtra("correo",emp.getCorreo());
                v.getContext().startActivity(launcher);
            }
        });

    }

}

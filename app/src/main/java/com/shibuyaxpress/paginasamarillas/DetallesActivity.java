package com.shibuyaxpress.paginasamarillas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetallesActivity extends AppCompatActivity {

    private TextView txtTelefono,txtNombre,txtDireccion,txtInfo;
    private ImageView imgEmpresa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        String info=getIntent().getStringExtra("info");
        String nombre=getIntent().getStringExtra("nombre");
        String direccion=getIntent().getStringExtra("direccion");
        String imagen=getIntent().getStringExtra("imagen");
        String telefono=getIntent().getStringExtra("telefono");
        //
        txtNombre=findViewById(R.id.det_nombre);
        txtTelefono=findViewById(R.id.det_telefono);
        txtDireccion=findViewById(R.id.det_direccion);
        txtInfo=findViewById(R.id.det_info);
        imgEmpresa=findViewById(R.id.det_img_empresa);


        txtNombre.setText(nombre);
        txtInfo.setText(info);
        txtDireccion.setText(direccion);
        txtTelefono.setText(telefono);
        Glide.with(getApplicationContext()).load(imagen).into(imgEmpresa);
    }
}

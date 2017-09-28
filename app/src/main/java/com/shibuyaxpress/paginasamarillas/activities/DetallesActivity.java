package com.shibuyaxpress.paginasamarillas.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.shibuyaxpress.paginasamarillas.R;

import java.net.URI;

public class DetallesActivity extends AppCompatActivity {

    private Button btnweb, btntelefono, btnCompartir, btnSMS;
    private TextView txtTelefono, txtNombre, txtDireccion, txtInfo;
    private ImageView imgEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        String info = getIntent().getStringExtra("info");
        String nombre = getIntent().getStringExtra("nombre");
        final String direccion = getIntent().getStringExtra("direccion");
        final String imagen = getIntent().getStringExtra("imagen");
        final String telefono = getIntent().getStringExtra("telefono");
        final String correo = getIntent().getStringExtra("correo");
        final String url = getIntent().getStringExtra("url");
        //
        txtNombre = findViewById(R.id.det_nombre);
        txtTelefono = findViewById(R.id.det_telefono);
        txtDireccion = findViewById(R.id.det_direccion);
        txtInfo = findViewById(R.id.det_info);
        imgEmpresa = findViewById(R.id.det_img_empresa);

        btnCompartir = findViewById(R.id.btn_compartir);
        btnSMS = findViewById(R.id.btn_sms);
        btntelefono = findViewById(R.id.btn_telefono);
        btnweb = findViewById(R.id.btn_web);

        txtNombre.setText(nombre);
        txtInfo.setText(info);
        txtDireccion.setText(direccion);
        txtTelefono.setText(telefono);
        Glide.with(getApplicationContext()).load(imagen).into(imgEmpresa);

        btnweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://"+url));
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        btntelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                try {
                    Intent intent=new Intent(Intent.ACTION_DIAL,Uri.parse(telefono));
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.i("Send email", "");
                    String[] TO = {correo};
                    String[] CC = {"paul.frankpc@gmail.com"};
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);

                    emailIntent.setData(Uri.parse("mailto:"));
                    emailIntent.setType("text/plain");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                    emailIntent.putExtra(Intent.EXTRA_CC, CC);
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

                    try {
                        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                        finish();
                        Log.i("Finished sending email.", "");
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(DetallesActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, direccion);
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}

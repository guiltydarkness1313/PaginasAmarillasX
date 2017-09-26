package com.shibuyaxpress.paginasamarillas;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        FragmentTabHost mtabHost=(FragmentTabHost)findViewById(R.id.tab_host);
        mtabHost.setup(ResultadoActivity.this,getSupportFragmentManager(),android.R.id.tabcontent);
        mtabHost.addTab(mtabHost.newTabSpec("First Tab").setIndicator("Resultados"), new TabResultadoFragment().getClass(), null);
        mtabHost.addTab(mtabHost.newTabSpec("Second Tab").setIndicator("Relacionados"), new TabRelacionadosFragment().getClass(), null);
    }
}

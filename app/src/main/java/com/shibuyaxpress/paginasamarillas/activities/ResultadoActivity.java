package com.shibuyaxpress.paginasamarillas.activities;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shibuyaxpress.paginasamarillas.R;
import com.shibuyaxpress.paginasamarillas.fragments.TabRelacionadosFragment;
import com.shibuyaxpress.paginasamarillas.fragments.TabResultadoFragment;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        FragmentTabHost mtabHost=(FragmentTabHost)findViewById(R.id.tab_host);
        mtabHost.setup(ResultadoActivity.this,getSupportFragmentManager(),android.R.id.tabcontent);
        mtabHost.addTab(mtabHost.newTabSpec("First Tab").setIndicator("Resultados"), TabResultadoFragment.class, null);
        mtabHost.addTab(mtabHost.newTabSpec("Second Tab").setIndicator("Relacionados"),TabRelacionadosFragment.class, null);
    }


}

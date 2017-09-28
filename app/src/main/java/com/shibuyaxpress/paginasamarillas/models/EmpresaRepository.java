package com.shibuyaxpress.paginasamarillas.models;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by paulf on 21-Sep-17.
 */

public class EmpresaRepository {

    private static EmpresaRepository _INSTANCE=null;
    private EmpresaRepository(){

    }

    public static EmpresaRepository getInstance(){
        if(_INSTANCE==null){
            _INSTANCE=new EmpresaRepository();
        }
        return _INSTANCE;
    }

    //empresas es la lista de empresas
    private List<Empresa> empresas=new ArrayList<>();

    public List<Empresa>getEmpresas(){
        return this.empresas;
    }

    public void agregarEmpresas(Empresa empresa){
        this.empresas.add(empresa);
    }

    public void Setempresas(){

    }

}

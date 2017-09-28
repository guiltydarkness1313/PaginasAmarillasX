package com.shibuyaxpress.paginasamarillas;

/**
 * Created by paulf on 28-Sep-17.
 */

public class Busqueda {
    private static Busqueda _INSTANCE=null;
    String key;
    private Busqueda(){

    }

    public static Busqueda getInstance(){
        if(_INSTANCE==null){
            _INSTANCE=new Busqueda();
        }
        return _INSTANCE;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}



package com.example.deber3_oscar_rai;

import java.util.ArrayList;

public class ModeloItemLists {
    private ItemList listaComida;
    private ItemList listaSalud;
    private ItemList listaEducacion;
    public static ModeloItemLists getInstance() {
        return ourInstance;
    }

    private static ModeloItemLists ourInstance = new ModeloItemLists();

    private ModeloItemLists(){
        listaComida=new ItemList("COMIDA");
        listaSalud=new ItemList("SALUD");
        listaEducacion=new ItemList("EDUCACION");
    }

    public ItemList getListaDeItems(int i){
        if(i==0)
            return listaComida;
        else if (i==1)
            return listaSalud;
        else
            return listaEducacion;
    }

    public double totalListas(){
        return listaComida.getTotal()+listaSalud.getTotal()+listaEducacion.getTotal();
    }
}

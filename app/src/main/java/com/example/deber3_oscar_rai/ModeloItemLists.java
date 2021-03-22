package com.example.deber3_oscar_rai;

//clase Singleton ModeloItemLists
public class ModeloItemLists {

    //miembros privados de la clase
    private ItemList listaComida;
    private ItemList listaSalud;
    private ItemList listaEducacion;
    public static ModeloItemLists getInstance() {
        return ourInstance;
    }

    private static ModeloItemLists ourInstance = new ModeloItemLists();

    //Constructor privado de la clase
    private ModeloItemLists(){
        listaComida=new ItemList("COMIDA");
        listaSalud=new ItemList("SALUD");
        listaEducacion=new ItemList("EDUCACION");
    }

    //Metodo que retorna una lista de items que se va trabajar
    public ItemList getListaDeItems(int i){
        if(i==0)
            return listaComida;
        else if (i==1)
            return listaSalud;
        else
            return listaEducacion;
    }

    //metodo que retorno la sumatoria total de los items
    public double totalListas(){
        return listaComida.getTotal()+listaSalud.getTotal()+listaEducacion.getTotal();
    }
}

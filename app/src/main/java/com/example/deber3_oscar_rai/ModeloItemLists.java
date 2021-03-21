package com.example.deber3_oscar_rai;

import java.util.ArrayList;

public class ModeloItemLists {
    private ArrayList<ItemList> listasItems;

    public static ModeloItemLists getInstance() {
        return ourInstance;
    }
    private static ModeloItemLists ourInstance = new ModeloItemLists();

    private ModeloItemLists(){
        ArrayList<ItemList> listasItems=new ArrayList<>(3);
    }

    public ItemList getListaDeItems(int i){
        return listasItems.get(i);
    }

    public double totalListas(){
        return listasItems.get(0).getTotal()+listasItems.get(1).getTotal()+listasItems.get(0).getTotal();
    }
}

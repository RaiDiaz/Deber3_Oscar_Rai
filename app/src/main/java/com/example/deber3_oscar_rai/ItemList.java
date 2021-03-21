package com.example.deber3_oscar_rai;
import java.util.ArrayList;

public class ItemList extends ArrayList<Item> {
    private double total;

    public ItemList(){
        total=0.0;
    }

    public void addItem(String descripcion,double valor){
        Item item= new Item(descripcion,valor);
        add(item);
        total+=item.getValor();
    }

    public void removeItem(Item item){
        remove(item);
        total-=item.getValor();
    }

    public void removeItem(int itemIndex){
        remove(itemIndex);
        total-=get(itemIndex).getValor();
    }

    public double getTotal() {
        return total;
    }
}
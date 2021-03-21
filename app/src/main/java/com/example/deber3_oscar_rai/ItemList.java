package com.example.deber3_oscar_rai;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;

public class ItemList extends ArrayList<Item> {
    private String nombreLista;
    private double total;

    public ItemList(String nombreLista){
        this.nombreLista=nombreLista;
        total=0.0;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addItem(String descripcion, double valor){
        Item item= new Item(descripcion,valor);
        add(item);
        total+=item.getValor();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void actualizarItem(int itemIndex, String descripcion, double valor){
        total-=get(itemIndex).getValor();
        get(itemIndex).setDescripcion(descripcion);
        get(itemIndex).setValor(valor);
        get(itemIndex).setFechaYHora();
        total+=get(itemIndex).getValor();
    }

    public void removeItem(Item item){
        remove(item);
        total-=item.getValor();
    }

    public void removeItem(int itemIndex){
        remove(itemIndex);
        total-=get(itemIndex).getValor();
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public double getTotal() {
        return total;
    }

    public String getNombreLista() { return nombreLista; }
}
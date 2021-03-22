package com.example.deber3_oscar_rai;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;

//ArrayList para manejo de Items
public class ItemList extends ArrayList<Item> {

    //datos miembro de la clase
    private String nombreLista;
    private double total;

    //constructor de la clase
    public ItemList(String nombreLista){
        this.nombreLista=nombreLista;
        total=0.0;
    }

    //metodo para agreggar items
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addItem(String descripcion, double valor){
        Item item= new Item(descripcion,valor);
        add(item);
        total+=item.getValor();
    }

    //metodo para actualizar items
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void actualizarItem(int itemIndex, String descripcion, double valor){
        total-=get(itemIndex).getValor();
        get(itemIndex).setDescripcion(descripcion);
        get(itemIndex).setValor(valor);
        get(itemIndex).setFechaYHora();
        total+=get(itemIndex).getValor();
    }

    //metodo para eliminar items
    public void removeItem(Item item){
        remove(item);
        total-=item.getValor();
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    //funciones gets de la clase
    public double getTotal() {
        return total;
    }

    public String getNombreLista() { return nombreLista; }
}
package com.example.deber3_oscar_rai;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.time.LocalDateTime;


public class Item{
    private String descripcion;
    private double valor;
    private LocalDateTime fechaYHora;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Item(){
        descripcion="Item";
        valor=12.5;
        fechaYHora=LocalDateTime.now();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Item(String descripcion, double valor){
        this.descripcion=descripcion;
        this.valor=valor;
        fechaYHora=LocalDateTime.now();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setFechaYHora() {
        fechaYHora=LocalDateTime.now();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    @Override
    public String toString() {
        return  "-> "+ descripcion  + "      valor = $" + valor +
                "\n " + fechaYHora;
    }

}

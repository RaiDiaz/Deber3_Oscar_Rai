package com.example.deber3_oscar_rai;
import java.time.LocalDateTime;

public class Item{
    private String descripcion;
    private double valor;
    private LocalDateTime fechaYHora;

    public Item(){
        descripcion="Item";
        valor=12.5;
        fechaYHora=LocalDateTime.now();
    }

    public Item(String descripcion,double valor){
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

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
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
}

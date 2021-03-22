package com.example.deber3_oscar_rai;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.time.LocalDateTime;


public class Item{
    //datos miembro de la clase
    private String descripcion;
    private double valor;
    private LocalDateTime fechaYHora;

    //constructores  de la clase
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

    //funciones sets de la calse
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

    //funciones gets de la clase
    public String getDescripcion() {
        return descripcion;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    //override del metodo toString
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public String toString() {

            return String.format("%1$45s", valor) + String.format("%1$22s", fechaYHora.getDayOfMonth()+"/"+fechaYHora.getMonthValue()+" "+fechaYHora.getHour()+":"+fechaYHora.getMinute()) + String.format("%1$20s", descripcion); //+ String.format("| %"+28+"s |\n", valor);

    }

}

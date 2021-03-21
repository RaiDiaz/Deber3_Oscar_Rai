package com.example.deber3_oscar_rai;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.Month;

public class Item implements Parcelable {
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected Item(Parcel in) {
        descripcion = in.readString();
        valor = in.readDouble();
        fechaYHora=LocalDateTime.of(in.readInt(),Month.of(in.readInt()),in.readInt(),in.readInt(),in.readInt(),in.readInt());
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(descripcion);
        dest.writeDouble(valor);
        dest.writeInt(fechaYHora.getYear());
        dest.writeInt(fechaYHora.getMonth().getValue());
        dest.writeInt(fechaYHora.getDayOfMonth());
        dest.writeInt(fechaYHora.getHour());
        dest.writeInt(fechaYHora.getMinute());
        dest.writeInt(fechaYHora.getSecond());
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

}

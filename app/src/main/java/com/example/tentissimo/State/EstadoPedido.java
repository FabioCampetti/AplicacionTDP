package com.example.tentissimo.State;

import com.example.tentissimo.Productos.Producto;

import java.util.Calendar;

public abstract class EstadoPedido {

    private String descripcion;
    private String color;

    public String getEstado(){
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setColor(String color){
        this.color=color;
    }

    public String getColor(){
        return color;
    }
}

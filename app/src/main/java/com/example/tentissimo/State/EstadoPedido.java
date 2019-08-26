package com.example.tentissimo.State;

import com.example.tentissimo.Productos.Producto;

import java.util.Calendar;

public abstract class EstadoPedido {

    private String descripcion;

    public String getEstado(){
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

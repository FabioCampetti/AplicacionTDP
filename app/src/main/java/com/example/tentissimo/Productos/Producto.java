package com.example.tentissimo.Productos;

import com.example.tentissimo.Precios;

import java.util.ArrayList;

public abstract class Producto {
    private String nombre;
    private ArrayList<String> ingredientes;
    private Precios precio=Precios.getInstance();
    private String tipo;

    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setIngredientes(ArrayList<String> ingredientes){
        this.ingredientes=ingredientes;
    }

    public String getNombre(){
        return nombre;
    }
    public String getTipo(){
        return tipo;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void añadirIngrediente(String ingrediente){
        ingredientes.add(ingrediente);
    }

    public Precios getPrecios(){
        return precio;
    }

    public abstract int getPrecio();
    
    public abstract Producto clone();
}

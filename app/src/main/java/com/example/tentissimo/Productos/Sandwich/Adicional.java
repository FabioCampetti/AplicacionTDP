package com.example.tentissimo.Productos.Sandwich;

import java.util.ArrayList;

public abstract class Adicional extends Sandwich {
    private String nombreAdicional;
    private Sandwich sandwich;

    public Sandwich getSandwich() {
        return sandwich;
    }

    public void setSandwich(Sandwich s){
        sandwich=s;
    }

    public int getPrecio() {
        return sandwich.getPrecio();
    }

    public ArrayList<String> getIngredientes() {
        return sandwich.getIngredientes();
    }

    public void setNombre(String nombre){
        nombreAdicional=nombre;
    }

    public String getNombreAdicional() {
        return nombreAdicional;
    }

    public String getNombre(){
        return sandwich.getNombre()+" + "+nombreAdicional;
    }
}

package com.example.tentissimo.Productos;

public class EmpanadaEspecial extends Empanada {

    public EmpanadaEspecial(String nombre){
        setNombre(nombre);
        setTipo("Empanada Especial");
    }

    public int getPrecio(){
        return getPrecios().getPrecioEmpanadaEspecial();
    }

    public EmpanadaEspecial clone(){
        EmpanadaEspecial e=new EmpanadaEspecial(getNombre());
        e.setIngredientes(getIngredientes());
        return e;
    }
}

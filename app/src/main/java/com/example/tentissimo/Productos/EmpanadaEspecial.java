package com.example.tentissimo.Productos;

import com.example.tentissimo.DataBaseHelper;

public class EmpanadaEspecial extends Empanada {
    private static final String TABLA_EMPANADAE="empanadasEspeciales";

    public EmpanadaEspecial(String nombre){
        setNombre(nombre);
    }

    public int getPrecio(){
        return getPrecios().getPrecioEmpanadaEspecial();
    }

    public EmpanadaEspecial clone(){
        EmpanadaEspecial e=new EmpanadaEspecial(getNombre());
        e.setIngredientes(getIngredientes());
        return e;
    }

    public String getTabla(){
        return TABLA_EMPANADAE;
    }

}

package com.example.tentissimo.Productos;

import com.example.tentissimo.DataBaseHelper;

public class EmpanadaComun extends Empanada {

    private static final String TABLA_EMPANADAC="empanadasComunes";

    public EmpanadaComun (String nombre){

        setNombre(nombre);
    }

    public int getPrecio(){
        return getPrecios().getPrecioEmpanadaComun();
    }


    public EmpanadaComun clone(){
        EmpanadaComun e= new EmpanadaComun(getNombre());
        e.setIngredientes(getIngredientes());
        return e;
    }

    public String getTabla(){
        return TABLA_EMPANADAC;
    }

}

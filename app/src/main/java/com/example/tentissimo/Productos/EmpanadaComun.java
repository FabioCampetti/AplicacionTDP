package com.example.tentissimo.Productos;

public class EmpanadaComun extends Empanada {

    public EmpanadaComun (String nombre){
        setNombre(nombre);
        setTipo("Empanada Comun");
    }

    public int getPrecio(){
        return getPrecios().getPrecioEmpanadaComun();
    }


    public EmpanadaComun clone(){
        EmpanadaComun e= new EmpanadaComun(getNombre());
        e.setIngredientes(getIngredientes());
        return e;
    }
}

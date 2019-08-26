package com.example.tentissimo.Productos;

import com.example.tentissimo.Precios;

public class Pizza extends Producto {

    public Pizza(String nombre){
        setNombre(nombre);
        setTipo("Pizza");
    }

    public int getPrecio(){
        return getPrecios().getPrecioPizza(getNombre());
    }

    public Pizza clone(){
        Pizza p=new Pizza(getNombre());
        p.setIngredientes(getIngredientes());
        return p;
    }

}

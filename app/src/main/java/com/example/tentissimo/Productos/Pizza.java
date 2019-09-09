package com.example.tentissimo.Productos;

import com.example.tentissimo.DataBaseHelper;
import com.example.tentissimo.Precios;

public class Pizza extends Producto {

    private static final String TABLA_PIZZAS="pizzas";

    public Pizza(String nombre){
        setNombre(nombre);
    }

    public int getPrecio(){
        return getPrecios().getPrecioPizza(getNombre());
    }

    public Producto clone(){
        Pizza p=new Pizza(getNombre());
        p.setIngredientes(getIngredientes());
        return p;
    }

    public String getTabla(){
        return TABLA_PIZZAS;
    }


}

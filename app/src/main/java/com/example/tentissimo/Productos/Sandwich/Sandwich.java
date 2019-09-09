package com.example.tentissimo.Productos.Sandwich;

import com.example.tentissimo.DataBaseHelper;
import com.example.tentissimo.Productos.Producto;

public abstract class Sandwich extends Producto {

    private static final String TABLA_SANDWICH="sandwiches";

    public abstract Sandwich clone();

    public String getTabla(){
        return TABLA_SANDWICH;
    }

}

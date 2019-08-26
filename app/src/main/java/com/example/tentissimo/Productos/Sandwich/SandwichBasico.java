package com.example.tentissimo.Productos.Sandwich;

public class SandwichBasico extends Sandwich {

    public SandwichBasico(String nombre){
        setNombre(nombre);
    }

    public int getPrecio() {
        return getPrecios().gerPrecioSandwich(getNombre());
    }

    public SandwichBasico clone(){
        SandwichBasico s=new SandwichBasico(getNombre());
        s.setIngredientes(getIngredientes());
        return s;
    }
}

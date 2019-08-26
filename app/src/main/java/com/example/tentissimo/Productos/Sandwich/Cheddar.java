package com.example.tentissimo.Productos.Sandwich;

public class Cheddar extends Adicional {

    public Cheddar(Sandwich s){
        setSandwich(s);
        setNombre("Cheddar");
        getSandwich().añadirIngrediente(getNombreAdicional());
    }

    public Cheddar clone(){
        return new Cheddar(getSandwich().clone());
    }
}

package com.example.tentissimo.Productos.Sandwich;

public class Jamon extends Adicional {

    public Jamon(Sandwich s){
        setSandwich(s);
        setNombre("Jamon");
        getSandwich().añadirIngrediente(getNombreAdicional());
    }

    public Jamon clone(){
        return new Jamon(getSandwich().clone());
    }
}

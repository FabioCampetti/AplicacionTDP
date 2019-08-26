package com.example.tentissimo.Productos.Sandwich;

public class Lechuga extends Adicional{

    public Lechuga(Sandwich s){
        setSandwich(s);
        setNombre("Lechuga");
        getSandwich().añadirIngrediente(getNombreAdicional());
    }

    public Lechuga clone(){
        return new Lechuga(getSandwich().clone());
    }
}

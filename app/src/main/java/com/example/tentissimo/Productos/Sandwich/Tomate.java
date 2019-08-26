package com.example.tentissimo.Productos.Sandwich;

public class Tomate extends Adicional{

    public Tomate(Sandwich s){
        setSandwich(s);
        setNombre("Tomate");
        s.añadirIngrediente(getNombreAdicional());
    }

    public Tomate clone(){
        Tomate t=new Tomate(getSandwich().clone());
        return t;
    }
}



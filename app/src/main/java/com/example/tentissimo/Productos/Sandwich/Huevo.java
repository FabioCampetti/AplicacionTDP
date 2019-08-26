package com.example.tentissimo.Productos.Sandwich;

public class Huevo extends Adicional {

    public Huevo(Sandwich s){
        setSandwich(s);
        setNombre("Huevo");
        getSandwich().añadirIngrediente(getNombreAdicional());
    }

    public Huevo clone(){
        return new Huevo(getSandwich().clone());
    }

}

package com.example.tentissimo.Productos.Sandwich;

public class SalsaRanchera extends Adicional {

    public SalsaRanchera(Sandwich s){
        setSandwich(s);
        setNombre("Salsa Ranchera");
        getSandwich().añadirIngrediente(getNombreAdicional());
    }

    public SalsaRanchera clone(){
        return new SalsaRanchera(getSandwich().clone());
    }
}

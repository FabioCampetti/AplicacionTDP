package com.example.tentissimo.Productos.Sandwich;

public class SalsaBarbacoa extends Adicional {

    public SalsaBarbacoa(Sandwich s){
        setSandwich(s);
        setNombre("Salsa Barbacoa");
        getSandwich().añadirIngrediente(getNombreAdicional());
    }

    public SalsaBarbacoa clone(){
        return new SalsaBarbacoa(getSandwich().clone());
    }
}

package com.example.tentissimo;

import com.example.tentissimo.Productos.EmpanadaComun;
import com.example.tentissimo.Productos.EmpanadaEspecial;
import com.example.tentissimo.Productos.Pizza;
import com.example.tentissimo.Productos.Producto;
import com.example.tentissimo.Productos.Sandwich.SandwichBasico;

public class FactoryProducto {


    public Producto crear(String tipo, String nombre){
        if(tipo=="Pizza")
            return new Pizza(nombre);
        else
            if (tipo=="Empanada Comun")
                    return new EmpanadaComun(nombre);
            else
                if(tipo=="Empanada Especial")
                    return new EmpanadaEspecial(nombre);
                else
                    return new SandwichBasico(nombre);

    }
}

package com.example.tentissimo;
import java.util.HashMap;
import java.util.Map;

public class Precios {

    private static Precios instance=new Precios();
    private int precioEmpanadaComun;
    private int precioEmpanadaEspecial;
    private Map<String,Integer> precioPizzas;
    private Map<String,Integer> precioSandwiches;

    private Precios (){
        precioEmpanadaComun=0;
        precioEmpanadaEspecial=0;
        precioPizzas= new HashMap<String,Integer>();
        precioSandwiches= new HashMap<String,Integer>();
    }

    public static Precios getInstance() {
        return instance;
    }

    public void setPrecioEmpanadaComun(int precioEmpanadaComun) {
        this.precioEmpanadaComun = precioEmpanadaComun;
    }

    public void setPrecioEmpanadaEspecial(int precioEmpanadaEspecial) {
        this.precioEmpanadaEspecial = precioEmpanadaEspecial;
    }

    public void setPrecioPizza(String nombre,int precio) {
        precioPizzas.put(nombre, precio);
    }

    public void setPrecioSandwiches(String nombre,int precio) {
        precioSandwiches.put(nombre,precio);
    }

    public int getPrecioEmpanadaComun() {
        return precioEmpanadaComun;
    }

    public int getPrecioEmpanadaEspecial() {
        return precioEmpanadaEspecial;
    }

    public int getPrecioPizza(String nombre){
        return precioPizzas.get(nombre);
    }

    public int gerPrecioSandwich(String nombre){
        return precioSandwiches.get(nombre);
    }
}

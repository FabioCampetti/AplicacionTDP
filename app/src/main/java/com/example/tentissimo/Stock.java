package com.example.tentissimo;

import com.example.tentissimo.Productos.Empanada;
import com.example.tentissimo.Productos.Pizza;
import com.example.tentissimo.Productos.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stock {
    private static Stock instance=new Stock();
    private Map<String,Map<Producto,Integer>> stock;


    private Stock(){
        stock= new HashMap<String,Map<Producto,Integer>>();
        añadirProductos("Empanada Comun");
        añadirProductos("Empanada Especial");
        añadirProductos("Pizza");
    }

    public static Stock getInstance() {
        return instance;
    }

    public void añadirStockProducto(String tipo,String producto, int cant){
        Map<Producto,Integer> stockProdcuto=stock.get(tipo);
            stockProdcuto.put(getProducto(tipo, producto),stockProdcuto.get(getProducto(tipo, producto))+cant);
    }

    public void añadirNuevoProducto(Producto p, int cant){
        stock.get(p.getTipo()).put(p,cant);
    }

    public int getCantidadProdcuto(String tipo, String producto){
        Map<Producto,Integer> stockProdcuto=stock.get(tipo);
        return stockProdcuto.get(getProducto(tipo, producto));
    }

    public List<String> getProductos(){
        return new ArrayList<String>(stock.keySet());
    }

    public Map<Producto,Integer> getStockProducto(String tipo){
        return stock.get(tipo);
    }

    public  List<Producto> getListaStockProducto(String tipo){
        return new ArrayList<Producto>(stock.get(tipo).keySet());
    }
    public void añadirProductos(String tipo){
        stock.put(tipo,new HashMap<Producto, Integer>());
    }

    private Producto getProducto(String tipo,String producto){
        Map<Producto,Integer> stockProdcuto=stock.get(tipo);
        Iterator<Producto> iterador=stockProdcuto.keySet().iterator();
        Producto p;
        while (iterador.hasNext())
        {
            p=iterador.next();
            if(p.getNombre().equals(producto))
                return p;
        }
        return null;
    }

    public boolean estaProducto(String tipo,String nombre){
        return getProducto(tipo,nombre)!=null;
    }
}



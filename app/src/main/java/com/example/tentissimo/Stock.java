package com.example.tentissimo;

import android.database.sqlite.SQLiteDatabase;

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
    private DataBaseHelper dataBase;


    private Stock() {
        stock = new HashMap<String, Map<Producto, Integer>>();
        añadirProductos("Empanada Comun");
        añadirProductos("Empanada Especial");
        añadirProductos("Pizza");
        añadirProductos("Sandwich");
    }

    public void setDAtaBase(DataBaseHelper db){
        dataBase=db;
        dataBase.getEmpanadasComunes(stock.get("Empanada Comun"));
        dataBase.getEmpanadasEspeciales(stock.get("Empanada Especial"));
        dataBase.getPizzas(stock.get("Pizza"));
        dataBase.getSandwiches(stock.get("Sandwich"));
    }

    public static Stock getInstance() {
        return instance;
    }

    public void añadirStockProducto(String tipo,String producto, int cant){
        Map<Producto,Integer> stockProducto=stock.get(tipo);
        Producto p=getProducto(tipo,producto);
        int actual=stockProducto.get(p);
        stockProducto.put(p,actual+cant);
        p.update(dataBase.escritura(),actual+cant);
    }

    public void añadirNuevoProducto(String tipo,Producto p, int cant){
        stock.get(tipo).put(p,cant);
       // p.update(dataBase.escritura(),cant);
        p.insert(dataBase.escritura(),cant);
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

    public Producto getProducto(String tipo,String producto){
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

    public void eliminarProducto(String tipo,String nombre){
        Map<Producto,Integer> stockProducto=stock.get(tipo);
        Producto p=getProducto(tipo,nombre);
        stockProducto.remove(p);
       p.delete(dataBase.escritura());
    }
}



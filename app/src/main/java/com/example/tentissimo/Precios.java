package com.example.tentissimo;
import android.content.ContentValues;

import java.util.HashMap;
import java.util.Map;

public class Precios {

    private static Precios instance=new Precios();
    private int precioEmpanadaComun;
    private int precioEmpanadaEspecial;
    private Map<String,Integer> precioPizzas;
    private Map<String,Integer> precioSandwiches;
    private static final String TABLA_PRECIO_PIZZA="precioPizza";
    private static final String TABLA_PRECIO_SAND="precioSandwich";
    private static final String TABLA_PRECIO_EMP="precioEmpanada";
    private static final String KEY_NOM="nomProd";
    private static final String KEY_PRE="precio";
    private DataBaseHelper dataBase;

    private Precios (){
        precioEmpanadaComun=25;
        precioEmpanadaEspecial=30;
        precioPizzas= new HashMap<String,Integer>();
        precioSandwiches= new HashMap<String,Integer>();
    }

    public void setDataBase(DataBaseHelper db){
        dataBase=db;
        dataBase.getPrecio(TABLA_PRECIO_PIZZA,precioPizzas);
        dataBase.getPrecio(TABLA_PRECIO_SAND,precioSandwiches);
        /*ContentValues values1= new ContentValues();
        values1.put(KEY_NOM,"Empanada Comun");
        values1.put(KEY_PRE,precioEmpanadaComun+"");
        dataBase.escritura().insert(TABLA_PRECIO_EMP,null,values1);
        ContentValues values= new ContentValues();
        values.put(KEY_NOM,"Empanada Especial");
        values.put(KEY_PRE,precioEmpanadaEspecial+"");
        dataBase.escritura().update(TABLA_PRECIO_EMP,values,KEY_NOM+" = ?",new String[]{String.valueOf("Empanada Especial")});*/

    }

    public static Precios getInstance() {
        return instance;
    }

    public void setPrecioEmpanadaComun(int precioEmpanadaComun) {
        this.precioEmpanadaComun = precioEmpanadaComun;
        ContentValues values= new ContentValues();
        values.put(KEY_NOM,"Empanada Comun");
        values.put(KEY_PRE,precioEmpanadaComun+"");
        dataBase.escritura().update(TABLA_PRECIO_EMP,values,KEY_NOM+" = ?",new String[]{String.valueOf("Empanada Comun")});

    }

    public void setPrecioEmpanadaEspecial(int precioEmpanadaEspecial) {
        this.precioEmpanadaEspecial = precioEmpanadaEspecial;
        ContentValues values= new ContentValues();
        values.put(KEY_NOM,"Empanada Especial");
        values.put(KEY_PRE,precioEmpanadaEspecial+"");
        dataBase.escritura().update(TABLA_PRECIO_EMP,values,KEY_NOM+" = ?",new String[]{String.valueOf("Empanada Especial")});
    }

    public void setPrecioPizza(String nombre,int precio) {
        ContentValues values= new ContentValues();
        values.put(KEY_NOM,nombre);
        values.put(KEY_PRE,precio+"");
        if(precioPizzas.containsKey(nombre))
            dataBase.escritura().update(TABLA_PRECIO_PIZZA,values,KEY_NOM+" = ?",new String[]{String.valueOf(nombre)});
        else
            dataBase.escritura().insert(TABLA_PRECIO_PIZZA,null,values);
        precioPizzas.put(nombre, precio);

    }

    public void setPrecioSandwiches(String nombre,int precio) {
        ContentValues values= new ContentValues();
        values.put(KEY_NOM,nombre);
        values.put(KEY_PRE,precio+"");
        if(precioSandwiches.containsKey(nombre))
            dataBase.escritura().update(TABLA_PRECIO_SAND,values,KEY_NOM+" = ?",new String[]{String.valueOf(nombre)});
        else
            dataBase.escritura().insert(TABLA_PRECIO_SAND,null,values);
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

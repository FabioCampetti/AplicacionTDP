package com.example.tentissimo.Productos;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.tentissimo.DataBaseHelper;
import com.example.tentissimo.Precios;

import java.util.ArrayList;

public abstract class Producto {
    private String nombre;
    private ArrayList<String> ingredientes;
    private Precios precio=Precios.getInstance();
    private static final String KEY_PROD="producto";
    private static final String KEY_INGRED="ingredientes";
    private static final String KEY_CANT="cantidad";

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setIngredientes(ArrayList<String> ingredientes){
        this.ingredientes=ingredientes;
    }

    public String getNombre(){
        return nombre;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void añadirIngrediente(String ingrediente){
        ingredientes.add(ingrediente);
    }

    public Precios getPrecios(){
        return precio;
    }

    public abstract String getTabla();

    public abstract int getPrecio();
    
    public abstract Producto clone();


    public void insert(SQLiteDatabase db, int cant){
        ContentValues values= new ContentValues();
        values.put(KEY_INGRED,"");
        values.put(KEY_CANT,cant);
        values.put(KEY_PROD,nombre);
        db.insert(getTabla(),null,values);
    }

    public void update(SQLiteDatabase db, int cant){
        ContentValues values= new ContentValues();
        values.put(KEY_INGRED,"");
        values.put(KEY_CANT,cant);
        values.put(KEY_PROD,nombre);
        db.update(getTabla(),values,KEY_PROD+" = ?",new String[]{String.valueOf(nombre)});
    }

    public void delete(SQLiteDatabase db){
        db.delete(getTabla(),KEY_PROD+" = ?",new String[]{String.valueOf(nombre)});
    }
}

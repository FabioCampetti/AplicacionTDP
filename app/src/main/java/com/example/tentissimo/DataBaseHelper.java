package com.example.tentissimo;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.tentissimo.Productos.EmpanadaComun;
import com.example.tentissimo.Productos.EmpanadaEspecial;
import com.example.tentissimo.Productos.Pizza;
import com.example.tentissimo.Productos.Producto;
import com.example.tentissimo.State.Cancelado;
import com.example.tentissimo.State.Entregado;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="Tenttisimo.db";

    //TABLAS
    private static final String TABLA_EMPANADAC="empanadasComunes";
    private static final String TABLA_EMPANADAE="empanadasEspeciales";
    private static final String TABLA_PIZZAS="pizzas";
    private static final String TABLA_SANDWICH="sandwiches";
    private static final String TABLA_PEDIDO="totalPedidos";
    private static final String TABLA_PRECIO_PIZZA="precioPizza";
    private static final String TABLA_PRECIO_SAND="precioSandwich";
    private static final String TABLA_PRECIO_EMP="precioEmpanada";


    //Colum names
    private static final String KEY_PROD="producto";
    private static final String KEY_INGRED="ingredientes";
    private static final String KEY_CANT="cantidad";

    //Colum names pedidos
    private static final String KEY_COD="codigo";
    private static final String KEY_NAME="nombre";
    private static final String KEY_DIR="direccio";
    private static final String KEY_TEL="telefono";
    private static final String KEY_COM="comentario";
    private static final String KEY_EST="estado";
    private static final String KEY_PIZZAS="pizza";
    private static final String KEY_EC="empanadaC";
    private static final String KEY_EE="empanadaE";
    private static final String KEY_SAND="sandwich";

    //Colum names precios
    private static final String KEY_NOM="nomProd";
    private static final String KEY_PRE="precio";

    private FactoryProducto fabrica;

    public DataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        fabrica=new FactoryProducto();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLA_PIZZAS +" ("+ KEY_PROD+" TEXT PRIMARY KEY,"+KEY_INGRED+" TEXT,"+KEY_CANT+" INTEGER"+")");
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLA_EMPANADAC +" ("+ KEY_PROD+" TEXT PRIMARY KEY,"+KEY_INGRED+" TEXT,"+KEY_CANT+" INTEGER"+")");
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLA_EMPANADAE +" ("+ KEY_PROD+" TEXT PRIMARY KEY,"+KEY_INGRED+" TEXT,"+KEY_CANT+" INTEGER"+")");
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLA_SANDWICH +" ("+KEY_PROD+" TEXT PRIMARY KEY,"+KEY_INGRED+" TEXT,"+KEY_CANT+" INTEGER"+")");
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLA_PEDIDO +" ("+KEY_COD+ " INTEGER PRIMARY KEY,"+KEY_NAME+" TEXT,"+KEY_DIR+" TEXT,"+KEY_TEL+" TEXT,"+KEY_COM+" TEXT,"+KEY_EST+" TEXT,"+KEY_PIZZAS+" TEXT,"+KEY_EC+" TEXT,"+KEY_EE+" TEXT,"+KEY_SAND+ " TEXT"+")");
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLA_PRECIO_PIZZA +" ("+KEY_NOM+" TEXT PRIMARY KEY,"+KEY_PRE+" TEXT"+")");
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLA_PRECIO_EMP +" ("+KEY_NOM+" TEXT PRIMARY KEY,"+KEY_PRE+" TEXT"+")");
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLA_PRECIO_SAND +" ("+KEY_NOM+" TEXT PRIMARY KEY,"+KEY_PRE+" TEXT"+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void getEmpanadasComunes(Map<Producto,Integer> mapeo){
        String selectQuery="SELECT * FROM "+TABLA_EMPANADAC;

        SQLiteDatabase db= this.getReadableDatabase();
        Cursor c=db.rawQuery(selectQuery,null);

        if (c.moveToFirst()){

            Log.i("tag","sasa");
            do{
                Producto prod=fabrica.crear("Empanada Comun",c.getString(c.getColumnIndex(KEY_PROD)));
                prod.setIngredientes(convert(c.getString(c.getColumnIndex(KEY_INGRED))));
                mapeo.put(prod,c.getInt(c.getColumnIndex(KEY_CANT)));
            }
            while (c.moveToNext());
        }

    }

    public void getEmpanadasEspeciales(Map<Producto,Integer> mapeo){
        String selectQuery="SELECT * FROM "+TABLA_EMPANADAE;

        SQLiteDatabase db= this.getReadableDatabase();
        Cursor c=db.rawQuery(selectQuery,null);

        if (c.moveToFirst()){

            Log.i("tag","sasa");
            do{
                Producto prod=fabrica.crear("Empanada Especial",c.getString(c.getColumnIndex(KEY_PROD)));
                prod.setIngredientes(convert(c.getString(c.getColumnIndex(KEY_INGRED))));
                mapeo.put(prod,c.getInt(c.getColumnIndex(KEY_CANT)));
            }
            while (c.moveToNext());
        }

    }

    public void getPizzas(Map<Producto,Integer> mapeo){
        String selectQuery="SELECT * FROM "+TABLA_PIZZAS;

        SQLiteDatabase db= this.getReadableDatabase();
        Cursor c=db.rawQuery(selectQuery,null);

        if (c.moveToFirst()){

            Log.i("tag","sasa");
            do{
                Producto prod=fabrica.crear("Pizza",c.getString(c.getColumnIndex(KEY_PROD)));
                prod.setIngredientes(convert(c.getString(c.getColumnIndex(KEY_INGRED))));
                mapeo.put(prod,c.getInt(c.getColumnIndex(KEY_CANT)));
            }
            while (c.moveToNext());
        }

    }

    public void getSandwiches(Map<Producto,Integer> mapeo){
        String selectQuery="SELECT * FROM "+TABLA_SANDWICH;

        SQLiteDatabase db= this.getReadableDatabase();
        Cursor c=db.rawQuery(selectQuery,null);

        if (c.moveToFirst()){

            Log.i("tag","sasa");
            do{
                Producto prod=fabrica.crear("Sandwich",c.getString(c.getColumnIndex(KEY_PROD)));
                prod.setIngredientes(convert(c.getString(c.getColumnIndex(KEY_INGRED))));
                mapeo.put(prod,c.getInt(c.getColumnIndex(KEY_CANT)));
            }
            while (c.moveToNext());
        }

    }
    public void getPrecio(String tabla,Map<String,Integer> mapeo) {
        String selectQuery = "SELECT * FROM " +tabla;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {

            Log.i("tag", "sasa");
            do {

                mapeo.put(c.getString(c.getColumnIndex(KEY_NOM)), c.getInt(c.getColumnIndex(KEY_PRE)));
            }
            while (c.moveToNext());
        }
    }

    public int getPrecioEmpandaE(){
        String selectQuery = "SELECT * FROM " +TABLA_PRECIO_EMP;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        int precio=0;

        if (c.moveToFirst()) {

            Log.i("tag", "sasa");
            do {
                    if(c.getString(c.getColumnIndex(KEY_NOM))=="Empanada Especial")
                    precio=c.getInt(c.getColumnIndex(KEY_PRE));
            }
            while (c.moveToNext());
        }
        return precio;
    }

    public int getPrecioEmpandaC(){
        String selectQuery = "SELECT * FROM " +TABLA_PRECIO_EMP;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        int precio=0;

        if (c.moveToFirst()) {

            Log.i("tag", "sasa");
            do {
                if(c.getString(c.getColumnIndex(KEY_NOM))=="Empanada Comun")
                    precio=c.getInt(c.getColumnIndex(KEY_PRE));
            }
            while (c.moveToNext());
        }
        return precio;
    }

    public void insertPedido(Pedido p){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(KEY_COD,p.getCodigo());
        values.put(KEY_NAME,p.getDestinatario());
        values.put(KEY_DIR,p.getDireccion());
        values.put(KEY_COM,p.getComentario());
        values.put(KEY_TEL,p.getTelefono()+"");
        values.put(KEY_EST,p.getColor());
        values.put(KEY_PIZZAS,convert(p.getPizza()));
        values.put(KEY_EC,convert(p.getEmpanadaC()));
        values.put(KEY_EE,convert(p.getEmpanadaE()));
        values.put(KEY_SAND,convert(p.getSandwich()));

        db.insert(TABLA_PEDIDO,null,values);
    }

    public void getPedidos(ArrayList<Pedido> lista){

        String selectQuery="SELECT * FROM "+TABLA_PEDIDO;

        FactoryProducto factory=new FactoryProducto();

        SQLiteDatabase db= this.getReadableDatabase();
        Cursor c=db.rawQuery(selectQuery,null);

        if (c.moveToFirst()){

            Log.i("tag","sasa");
            do{
                Pedido p=new Pedido();
                p.setCodigo(Integer.parseInt(c.getString(c.getColumnIndex(KEY_COD))));
                p.setDestinatario(c.getString(c.getColumnIndex(KEY_NAME)));
                p.setComentario(c.getString(c.getColumnIndex(KEY_COM)));
                p.setDireccion(c.getString(c.getColumnIndex(KEY_DIR)));
                p.setTelefono(Integer.parseInt(c.getString(c.getColumnIndex(KEY_TEL))));

                for(String s:convert(c.getString(c.getColumnIndex(KEY_PIZZAS)))) {
                    if(s!="")
                    {Producto prod = factory.crear("Pizza", s);
                    p.añadirProducto("Pizza",prod);}
                }
                for(String s:convert(c.getString(c.getColumnIndex(KEY_EC)))) {
                    if(s!="")
                    {Producto prod = factory.crear("Empanada Comun", s);
                    p.añadirProducto("Empanada Comun",prod);}
                }
                for(String s:convert(c.getString(c.getColumnIndex(KEY_EE)))) {
                    if(s!="")
                    {Producto prod = factory.crear("Empanada Especial", s);
                    p.añadirProducto("Empanada Especial",prod);}
                }
                for(String s:convert(c.getString(c.getColumnIndex(KEY_SAND)))) {
                    Producto prod = factory.crear("Sandwich", s);
                    p.añadirProducto("Sandwich",prod);
                }
                /*Producto prod=new EmpanadaEspecial(c.getString((c.getColumnIndex(KEY_EE))));
                p.añadirProducto("Empanada Especial",prod);*/
                if(c.getString(c.getColumnIndex(KEY_EST))=="#008f39")
                    p.setEstado(new Entregado());
                    else
                    {if(c.getString(c.getColumnIndex(KEY_EST))=="#ff0000")
                        p.setEstado(new Cancelado());}


                    lista.add(p);
            }
            while (c.moveToNext());
        }

    }

   /* public void insert(String dB,Producto p, int cant){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(KEY_INGRED,"");
        values.put(KEY_CANT,cant);
        values.put(KEY_PROD,p.getNombre());
        db.insert(dB,null,values);
    }*/

    /*public void update(SQLiteDatabase db, int cant){
        ContentValues values= new ContentValues();
        values.put(KEY_INGRED,"");
        values.put(KEY_CANT,cant);
        values.put(KEY_PROD,nombre);
        db.update(getTabla(),values,KEY_PROD+" = ?",new String[]{String.valueOf(nombre)});
    }

    public void delete(SQLiteDatabase db){
        db.delete(getTabla(),KEY_PROD+" = ?",new String[]{String.valueOf(nombre)});
    }*/

    public void updatePedido(Pedido p){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(KEY_COD,p.getCodigo());
        values.put(KEY_NAME,p.getDestinatario());
        values.put(KEY_DIR,p.getDireccion());
        values.put(KEY_COM,p.getComentario());
        values.put(KEY_TEL,p.getTelefono()+"");
        values.put(KEY_EST,p.getColor());
        values.put(KEY_PIZZAS,convert(p.getPizza()));
        values.put(KEY_EC,convert(p.getEmpanadaC()));
        values.put(KEY_EE,convert(p.getEmpanadaE()));
        values.put(KEY_SAND,convert(p.getSandwich()));

        db.update(TABLA_PEDIDO,values,KEY_COD+" = ?",new String[]{String.valueOf(p.getCodigo())});
    }
    public ArrayList<String> convert(String list){
        return new ArrayList<String>(Arrays.asList(list.split(",")));
    }

    public String convert(ArrayList<Producto> list){
        ArrayList<String> toRet=new ArrayList<String>();
        for(Producto p:list)
            toRet.add(p.getNombre());

        return android.text.TextUtils.join(",",toRet);
    }

    public SQLiteDatabase escritura(){
        return this.getWritableDatabase();
    }
}

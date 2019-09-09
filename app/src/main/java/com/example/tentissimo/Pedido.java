package com.example.tentissimo;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.tentissimo.Productos.Producto;
import com.example.tentissimo.State.Encargado;
import com.example.tentissimo.State.EstadoPedido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pedido{
    private Map<String, ArrayList<Producto>> pedido;
    private int codigo;
    private String destinatario;
    private String direccion;
    private int telefono;
    private EstadoPedido estado;
    private String comentario;

    public Pedido() {
        estado = new Encargado();
        pedido = new HashMap<String, ArrayList<Producto>>() {};
        pedido.put("Empanada Especial",new ArrayList<Producto>());
        pedido.put("Empanada Comun",new ArrayList<Producto>());
        pedido.put("Pizza",new ArrayList<Producto>());
        pedido.put("Sandwich",new ArrayList<Producto>());
    }


    public String getEstado() {
        return estado.getEstado();
    }

    public String getColor() {
        return estado.getColor();
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void añadirProducto(String tipo,Producto p) {
        pedido.get(tipo).add(p);
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public int getPrecio() {
        int precio = 0;
        for(String tipo:pedido.keySet())
            for (Producto p : pedido.get(tipo))
            precio += p.getPrecio();
        return precio;
    }

    public ArrayList<Producto> getPedido(){
        ArrayList<Producto> toRet=new ArrayList<Producto>();
        for(String tipo:pedido.keySet())
            for (Producto p : pedido.get(tipo))
                toRet.add(p);
        return toRet;
    }

    public ArrayList<Producto> getPizza(){
        return pedido.get("Pizza");
    }

    public ArrayList<Producto> getEmpanadaC(){
        return pedido.get("Empanada Comun");
    }

    public ArrayList<Producto> getEmpanadaE(){
        return pedido.get("Empanada Especial");
    }

    public ArrayList<Producto> getSandwich(){
        return pedido.get("Sandwich");
    }
}

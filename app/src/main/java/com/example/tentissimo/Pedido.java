package com.example.tentissimo;

import com.example.tentissimo.Productos.Producto;
import com.example.tentissimo.State.Encargado;
import com.example.tentissimo.State.EstadoPedido;

import java.util.ArrayList;

public class Pedido {
    private ArrayList<Producto> pedido;
    private int codigo;
    private String destinatario;
    private String direccion;
    private EstadoPedido estado;

    public Pedido(){
        estado=new Encargado();
    }


    public String getDescripcion() {
        return estado.getEstado();
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

    public String getDireccion() {
        return direccion;
    }

    public String getDestinatario(){
        return destinatario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}

package com.example.tentissimo;

import java.util.ArrayList;

public class Pedidos {

    private ArrayList<Pedido> pedidos;
    private static Pedidos instance=new Pedidos();

    private Pedidos(){
        pedidos= new ArrayList<Pedido>();
        Pedido p1= new Pedido();
        p1.setDestinatario("Fabio");
        p1.setDireccion("Bolivar 510");
        pedidos.add(p1);
    }

    public static Pedidos getInstance(){
        return instance;
    }

    public void addPedido(Pedido p){
        pedidos.add(p);
    }

   public ArrayList<Pedido> getPedidos(){
        return pedidos;
   }
}

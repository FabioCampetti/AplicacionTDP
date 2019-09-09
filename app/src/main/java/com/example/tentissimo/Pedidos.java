package com.example.tentissimo;

import java.util.ArrayList;

public class Pedidos {

    private ArrayList<Pedido> pedidos;
    private static Pedidos instance=new Pedidos();
    private int cantPedidos;
    private DataBaseHelper dataBase;

    private Pedidos(){
        pedidos= new ArrayList<Pedido>();
        cantPedidos=0;
    }

    public static Pedidos getInstance(){
        return instance;
    }

    public void setDataBase(DataBaseHelper db){
        dataBase=db;
        dataBase.getPedidos(pedidos);
        cantPedidos=pedidos.size();
    }
    public void addPedido(Pedido p){
        cantPedidos++;
        p.setCodigo(cantPedidos);
        pedidos.add(p);
    }

    public void aceptar(Pedido p){
        dataBase.insertPedido(p);
    }

    public void modificar(Pedido p){
        dataBase.updatePedido(p);
    }

   public ArrayList<Pedido> getPedidos(){
        return pedidos;
   }

   public Pedido getPedidoEspecifico(int codigo){
        for(Pedido p:pedidos)
            if(p.getCodigo()==codigo)
                return p;
        return null;
   }
}

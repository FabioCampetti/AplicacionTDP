package com.example.tentissimo.State;
import java.util.Calendar;
public class Entregado extends EstadoPedido {

    public Entregado(){
        setDescripcion("El pedido fue entregado: "+java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime() ));
    }

}

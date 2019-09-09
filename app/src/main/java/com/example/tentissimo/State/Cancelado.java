package com.example.tentissimo.State;

import java.util.Calendar;

public class Cancelado extends EstadoPedido {

    public Cancelado(){
        setDescripcion("El pedido fue cancelado: "+java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime() ));
        setColor("#ff0000");
    }
}


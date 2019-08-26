package com.example.tentissimo.State;

import java.util.Calendar;

public class Encargado extends EstadoPedido {

    public Encargado(){
        setDescripcion("El pedido fue encargado: "+java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime() ));
    }
}


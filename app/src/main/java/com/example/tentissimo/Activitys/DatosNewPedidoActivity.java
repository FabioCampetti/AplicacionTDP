package com.example.tentissimo.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tentissimo.Pedido;
import com.example.tentissimo.Pedidos;
import com.example.tentissimo.R;

import java.io.Serializable;

public class DatosNewPedidoActivity extends AppCompatActivity implements Serializable {

    private Pedidos pedidos= Pedidos.getInstance();
    private int codigo;
    private EditText nombre;
    private EditText direccion;
    private EditText telefono;
    private EditText comentario;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_new_pedidos);
        Intent intent=getIntent();
        codigo=intent.getIntExtra("nroPedido",0);
        nombre =(EditText) findViewById(R.id.Nombre);
        direccion =(EditText) findViewById(R.id.Direccion);
        telefono =(EditText) findViewById(R.id.Telefono);
        comentario =(EditText) findViewById(R.id.Comentario);

    }

    public void Confirmar(View view){
        Pedido p=pedidos.getPedidoEspecifico(codigo);
        p.setDestinatario(nombre.getText().toString());
        p.setDireccion(direccion.getText().toString());
        p.setTelefono(Integer.parseInt(telefono.getText().toString()));
        p.setComentario(comentario.getText().toString());
        pedidos.aceptar(p);
        finish();
        Toast.makeText(DatosNewPedidoActivity.this,"Pedido Realizado", Toast.LENGTH_SHORT).show();

    }
}

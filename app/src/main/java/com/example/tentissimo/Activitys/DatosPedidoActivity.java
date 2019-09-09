package com.example.tentissimo.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tentissimo.AdapterPedido;
import com.example.tentissimo.Pedido;
import com.example.tentissimo.Pedidos;
import com.example.tentissimo.R;
import com.example.tentissimo.State.Cancelado;
import com.example.tentissimo.State.Entregado;

public class DatosPedidoActivity extends AppCompatActivity {

    private Pedidos pedidos= Pedidos.getInstance();
    private int codigo;
    private TextView nombre;
    private TextView telefono;
    private TextView comentario;
    private RecyclerView recyclerView;
    private Pedido pedidoEspecifico;
    private AdapterPedido adaptador;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_pedido);
        Intent intent=getIntent();
        codigo=intent.getIntExtra("codPedido",0);
        pedidoEspecifico=pedidos.getPedidoEspecifico(codigo);
        nombre=(TextView) findViewById(R.id.NombreDestinatario);
        telefono=(TextView) findViewById(R.id.TelefonoDestinatario);
        comentario=(TextView) findViewById(R.id.Comentario);
        recyclerView=(RecyclerView) findViewById(R.id.ListaProductos);

        nombre.setText(pedidoEspecifico.getDestinatario());
        telefono.setText(pedidoEspecifico.getTelefono()+"");
        comentario.setText(pedidoEspecifico.getComentario());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaptador = new AdapterPedido(pedidoEspecifico.getPedido(), this);
        recyclerView.setAdapter(adaptador);
    }

    public void entregar(View view){
        pedidoEspecifico.setEstado(new Entregado());
        pedidos.modificar(pedidoEspecifico);
        Toast.makeText(DatosPedidoActivity.this,"Producto entregado", Toast.LENGTH_SHORT).show();

    }

    public void cancelar(View view){
        pedidoEspecifico.setEstado(new Cancelado());
        pedidos.modificar(pedidoEspecifico);
        Toast.makeText(DatosPedidoActivity.this,"Producto cancelado", Toast.LENGTH_SHORT).show();
    }
}

package com.example.tentissimo.Activitys;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tentissimo.Adapter;
import com.example.tentissimo.Pedidos;
import com.example.tentissimo.R;

import java.util.ArrayList;

public class PedidosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private Pedidos pedidos= Pedidos.getInstance();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        recyclerView =(RecyclerView) findViewById(R.id.ListaPedidos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(pedidos.getPedidos(),this);
        recyclerView.setAdapter(adapter);
    }
}

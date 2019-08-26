package com.example.tentissimo.Activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tentissimo.AdapterProductoPedido;
import com.example.tentissimo.Productos.Producto;
import com.example.tentissimo.R;
import com.example.tentissimo.Stock;

import java.util.HashMap;
import java.util.Map;

public class NewPedidoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private RecyclerView recyclerView;
    private Map<String, Map<String, Integer>> productosElegidos;
    private Spinner tipoProducto;
    private Stock stock = Stock.getInstance();
    private AdapterProductoPedido adaptador;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pedido);
        productosElegidos = new HashMap<String, Map<String, Integer>>();
        for (String tipo : stock.getProductos()) {
            productosElegidos.put(tipo, new HashMap<String, Integer>());
            for (Producto p : stock.getListaStockProducto(tipo))
                productosElegidos.get(tipo).put(p.getNombre(), 0);
        }
        tipoProducto = (Spinner) findViewById(R.id.spinner);
        tipoProducto.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stock.getProductos());
        tipoProducto.setAdapter(adapter);
        recyclerView = (RecyclerView) findViewById(R.id.Productos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaptador = new AdapterProductoPedido(tipoProducto.getSelectedItem().toString(), productosElegidos, this);
        recyclerView.setAdapter(adaptador);

    }

    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        String item = parent.getItemAtPosition(i).toString();
        adaptador = new AdapterProductoPedido(tipoProducto.getSelectedItem().toString(), productosElegidos, this);
        recyclerView.setAdapter(adaptador);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void aumentar(View view){
        AdapterProductoPedido.ViewHolder viewHolder= (AdapterProductoPedido.ViewHolder) recyclerView.getChildViewHolder(view);
        String nombreProd=viewHolder.getProducto().toString();
        Map<String,Integer> map=productosElegidos.get(tipoProducto.getSelectedItem().toString());
        map.put(nombreProd,map.get(nombreProd)+1);
        viewHolder.getCantidad().setText(String.valueOf(map.get(nombreProd)));
        Toast.makeText(NewPedidoActivity.this,"Aumeno",Toast.LENGTH_SHORT);
    }

}

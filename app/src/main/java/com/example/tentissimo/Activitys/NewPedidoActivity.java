package com.example.tentissimo.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tentissimo.AdapterProductoPedido;
import com.example.tentissimo.Pedido;
import com.example.tentissimo.Pedidos;
import com.example.tentissimo.Productos.Producto;
import com.example.tentissimo.R;
import com.example.tentissimo.Stock;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class NewPedidoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private RecyclerView recyclerView;
    private Map<String, Map<String, Integer>> productosElegidos;
    private Spinner tipoProducto;
    private Stock stock = Stock.getInstance();
    private Pedidos pedidos= Pedidos.getInstance();
    private AdapterProductoPedido adaptador;
    private TextView cantidadProductos;
    private TextView totalPrecio;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pedido);
        cantidadProductos=(TextView) findViewById(R.id.CantidadProductos);
        totalPrecio=(TextView) findViewById(R.id.PrecioTotal);
        productosElegidos = new HashMap<String, Map<String, Integer>>();
        resetearElegidos();
        tipoProducto = (Spinner) findViewById(R.id.spinner);
        tipoProducto.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stock.getProductos());
        tipoProducto.setAdapter(adapter);
        recyclerView = (RecyclerView) findViewById(R.id.Productos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaptador = new AdapterProductoPedido(tipoProducto.getSelectedItem().toString(), productosElegidos, this,cantidadProductos,totalPrecio);
        recyclerView.setAdapter(adaptador);
    }

    protected void onStart(){
        super.onStart();
        adaptador.notifyDataSetChanged();
    }

    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        String item = parent.getItemAtPosition(i).toString();
        adaptador = new AdapterProductoPedido(tipoProducto.getSelectedItem().toString(), productosElegidos, this,cantidadProductos,totalPrecio);
        recyclerView.setAdapter(adaptador);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void resetearElegidos(){
        for (String tipo : stock.getProductos()) {
            productosElegidos.put(tipo, new HashMap<String, Integer>());
            for (Producto p : stock.getListaStockProducto(tipo))
                productosElegidos.get(tipo).put(p.getNombre(), 0);
        }
    }

    public void agregarPedido(View view){
        Pedido p=new Pedido();
        for(String tipo:productosElegidos.keySet())
                for(String prod:productosElegidos.get(tipo).keySet())
                        if(productosElegidos.get(tipo).get(prod)>0)
                            for(int i=0;i<productosElegidos.get(tipo).get(prod);i++)
                            {Producto produc=stock.getProducto(tipo,prod);
                                if(produc!=null) {
                                    Producto espe=produc.clone();
                                    p.añadirProducto(tipo,espe);
                                    stock.añadirStockProducto(tipo,espe.getNombre(),-1);

                                }
                                }
        pedidos.addPedido(p);
        Intent intent= new Intent(NewPedidoActivity.this, DatosNewPedidoActivity.class);
        intent.putExtra("nroPedido",p.getCodigo());
        this.onPause();
        this.startActivity(intent);
        resetearElegidos();
        cantidadProductos.setText(0+"");
        totalPrecio.setText(0+"");
    }
}

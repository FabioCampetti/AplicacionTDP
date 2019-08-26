package com.example.tentissimo.Activitys;

import android.os.Bundle;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tentissimo.AdapterStock;
import com.example.tentissimo.R;

import com.example.tentissimo.Stock;

public class ControlarStockActivity extends AppCompatActivity implements OnItemSelectedListener{

    private RecyclerView recyclerView;
    private AdapterStock adaptador;
    private Spinner tipoProducto;
    private Stock stock = Stock.getInstance();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controlar_stock);
        tipoProducto = (Spinner) findViewById(R.id.TipoProducto);
        tipoProducto.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stock.getProductos());
        tipoProducto.setAdapter(adapter);
        recyclerView = (RecyclerView) findViewById(R.id.ListaStock);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaptador = new AdapterStock(tipoProducto.getSelectedItem().toString(), this);
        recyclerView.setAdapter(adaptador);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        String item=parent.getItemAtPosition(i).toString();
        adaptador = new AdapterStock(tipoProducto.getSelectedItem().toString(), this);
        recyclerView.setAdapter(adaptador);


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void alClick(View view){
        Toast.makeText(this,"Hiciste click",Toast.LENGTH_SHORT).show();
    }
}
package com.example.tentissimo.Activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tentissimo.FactoryProducto;
import com.example.tentissimo.Productos.Empanada;
import com.example.tentissimo.Productos.EmpanadaComun;
import com.example.tentissimo.Productos.EmpanadaEspecial;
import com.example.tentissimo.Productos.Pizza;
import com.example.tentissimo.Productos.Producto;
import com.example.tentissimo.R;
import com.example.tentissimo.Stock;

public class AdministrarStockActivity extends AppCompatActivity {

    private Stock stock=Stock.getInstance();
    private Spinner producto;
    private EditText nombre;
    private EditText cantidad;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administar_stock);
        nombre=(EditText) findViewById(R.id.NombreProducto);
        cantidad= (EditText) findViewById(R.id.CantidadProducto);
        producto =(Spinner) findViewById(R.id.Producto);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,stock.getProductos());
        producto.setAdapter(adapter);

    }

    public void agregar(View view){
        String name=nombre.getText().toString();
        int cant=Integer.parseInt(cantidad.getText().toString());
        String produtcoSelec=producto.getSelectedItem().toString();
        nombre.setText("");
        cantidad.setText("");
        if(stock.estaProducto(produtcoSelec,name))
        {
            stock.añadirStockProducto(produtcoSelec,name,cant);
            Toast.makeText(AdministrarStockActivity.this,"Stock Producto Aumentado", Toast.LENGTH_SHORT).show();
        }

        else
            {
                FactoryProducto f1=new FactoryProducto();
                Producto agregarNuevo=f1.crear(produtcoSelec,name);
                stock.añadirNuevoProducto(agregarNuevo,cant);
                Toast.makeText(AdministrarStockActivity.this,"Stock Producto Nuevo Agregado", Toast.LENGTH_SHORT).show();
            }


    }

}

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
import com.example.tentissimo.Precios;
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
    private Precios precios=Precios.getInstance();
    private EditText nombre;
    private EditText cantidad;
    private EditText precio;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administar_stock);
        nombre=(EditText) findViewById(R.id.NombreProducto);
        cantidad= (EditText) findViewById(R.id.CantidadProducto);
        producto =(Spinner) findViewById(R.id.Producto);
        precio=(EditText) findViewById(R.id.Precio);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,stock.getProductos());
        producto.setAdapter(adapter);

    }

    public void agregar(View view){
        String name=nombre.getText().toString();
        int cant=Integer.parseInt(cantidad.getText().toString());
        String produtcoSelec=producto.getSelectedItem().toString();
        if(stock.estaProducto(produtcoSelec,name))
        {
            stock.añadirStockProducto(produtcoSelec,name,cant);
            Toast.makeText(AdministrarStockActivity.this,"Stock Producto Aumentado", Toast.LENGTH_SHORT).show();
        }

        else
            {
                if((produtcoSelec!="Pizza"&& produtcoSelec!="Sandwich") || !precio.getText().toString().matches(""))
                    {
                    FactoryProducto f1=new FactoryProducto();
                    Producto agregarNuevo=f1.crear(produtcoSelec,name);
                    stock.añadirNuevoProducto(produtcoSelec,agregarNuevo,cant);
                    if(produtcoSelec=="Pizza")
                        precios.setPrecioPizza(name,Integer.parseInt(precio.getText().toString()));
                    else
                        if(produtcoSelec=="Sandwich")
                            precios.setPrecioSandwiches(name,Integer.parseInt(precio.getText().toString()));
                            nombre.setText("");
                            cantidad.setText("");
                            precio.setText("");
                            Toast.makeText(AdministrarStockActivity.this,"Stock Producto Nuevo Agregado", Toast.LENGTH_SHORT).show();}
                else
                    Toast.makeText(AdministrarStockActivity.this,"Falta indicar el precio", Toast.LENGTH_SHORT).show();
            }


    }

    public void decrementar(View view){
        String name=nombre.getText().toString();
        int cant=Integer.parseInt(cantidad.getText().toString());
        String produtcoSelec=producto.getSelectedItem().toString();
        nombre.setText("");
        cantidad.setText("");
        precio.setText("");
        if(stock.estaProducto(produtcoSelec,name))
            if(cant <= stock.getCantidadProdcuto(produtcoSelec,name))
            {
                stock.añadirStockProducto(produtcoSelec,name,(cant*-1));
                Toast.makeText(AdministrarStockActivity.this,"Stock Producto Decrementado", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(AdministrarStockActivity.this,"Stock Producto Insuficiente", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(AdministrarStockActivity.this,"Producto Inexistente", Toast.LENGTH_SHORT).show();

    }

    public void eliminar(View view){
        String name=nombre.getText().toString();
        String produtcoSelec=producto.getSelectedItem().toString();
        nombre.setText("");
        cantidad.setText("");
        precio.setText("");
        if(stock.estaProducto(produtcoSelec,name))
        {
            stock.eliminarProducto(produtcoSelec,name);
            Toast.makeText(AdministrarStockActivity.this,"Producto Eliminado", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(AdministrarStockActivity.this,"Producto Inexistente", Toast.LENGTH_SHORT).show();
    }

}

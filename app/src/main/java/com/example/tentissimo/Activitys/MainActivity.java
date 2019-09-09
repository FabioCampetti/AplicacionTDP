package com.example.tentissimo.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.example.tentissimo.DataBaseHelper;
import com.example.tentissimo.Pedidos;
import com.example.tentissimo.Precios;
import com.example.tentissimo.R;
import com.example.tentissimo.Stock;

public class MainActivity extends AppCompatActivity {

    private Stock stock= Stock.getInstance();
    private Pedidos pedidos=Pedidos.getInstance();
    private Precios precios=Precios.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBaseHelper db=new DataBaseHelper(this);
        stock.setDAtaBase(db);
        pedidos.setDataBase(db);
        precios.setDataBase(db);
    }

    public void nextActivity(View view) {
        Intent intent = new Intent(MainActivity.this, PedidosActivity.class);

        this.startActivity(intent);

    }

    public void stockActivity(View view){
        Intent intent = new Intent(MainActivity.this,StockActivity.class);

        this.startActivity(intent);
    }

    public void newPedidoActivity(View view){
        Intent intent = new Intent(MainActivity.this,NewPedidoActivity.class);

        this.startActivity(intent);
    }

    public void infoActivity(View view){
        Intent intent = new Intent(MainActivity.this,InfoActivity.class);

        this.startActivity(intent);
    }

}

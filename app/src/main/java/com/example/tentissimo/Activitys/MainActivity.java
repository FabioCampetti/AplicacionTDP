package com.example.tentissimo.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tentissimo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

}

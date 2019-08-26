package com.example.tentissimo.Activitys;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tentissimo.R;

public class StockActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
    }

    public void administrarStock(View view){
        Intent intent= new Intent(StockActivity.this, AdministrarStockActivity.class);
        this.startActivity(intent);
    }

    public void controlarStock(View view){
        Intent intent= new Intent(StockActivity.this, ControlarStockActivity.class);
        this.startActivity(intent);
    }

}

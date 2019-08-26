package com.example.tentissimo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tentissimo.Productos.Producto;

import java.util.ArrayList;
import java.util.Map;

public class AdapterStock extends RecyclerView.Adapter<AdapterStock.ViewHolder> {
    private Stock stock=Stock.getInstance();
    private Map<Producto,Integer> productos;
    private ArrayList<Producto> listaProductos;
    private Context context;
    private String producto;

    public AdapterStock(String producto, Context context) {
        this.context = context;
        this.producto = producto;
        productos=stock.getStockProducto(producto);
        listaProductos=(ArrayList<Producto>) stock.getListaStockProducto(producto);
    }
        public ViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.stock, parent, false);
            return new ViewHolder(v);
        }


        @Override
        public void onBindViewHolder (@NonNull ViewHolder holder,int position){
            Producto p=listaProductos.get(position);
            String prodEspecifico=p.getNombre();
            holder.getProducto().setText(prodEspecifico);
            holder.getCantidad().setText(String.valueOf(stock.getCantidadProdcuto(producto,prodEspecifico)));
        }


    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView producto;
        private TextView cantidad;

        public ViewHolder(View itemView){
            super(itemView);
            producto=(TextView) itemView.findViewById(R.id.Nombre);
            cantidad=(TextView) itemView.findViewById(R.id.Cantidad);
        }

        public TextView getCantidad() {
            return cantidad;
        }

        public TextView getProducto() {
            return producto;
        }
    }
}

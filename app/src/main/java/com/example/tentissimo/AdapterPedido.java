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

public class AdapterPedido extends RecyclerView.Adapter<AdapterPedido.ViewHolder> {
    private ArrayList<Producto> lista;
    private Context context;

    public AdapterPedido(ArrayList<Producto> lista,Context context){
        this.lista=lista;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_pedido,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Producto actual=lista.get(position);
        holder.getNombre().setText(" "+actual.getNombre());
        holder.getCantidad().setText("$"+actual.getPrecio());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre;
        private TextView cantidad;

        public ViewHolder(View itemView){
            super(itemView);
            nombre=(TextView) itemView.findViewById(R.id.ProductoDelPed);
            cantidad=(TextView) itemView.findViewById(R.id.CantidadDelProd);
        }

        public TextView getNombre(){
            return nombre;
        }

        public TextView getCantidad(){
            return cantidad;
        }
    }
}

package com.example.tentissimo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Pedido> lista;
    private Context context;

    public Adapter(ArrayList<Pedido> lista, Context context){
        this.lista=lista;
        this.context=context;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pedido,parent,false);
        return new ViewHolder(v);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        Pedido pedido= lista.get(position);
        holder.getDescripcion().setText(pedido.getDescripcion());
        holder.getDireccion().setText(pedido.getDireccion());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView Direccion;
        private TextView Descripcion;
        public ViewHolder(View itemView){
            super(itemView);
            Direccion=(TextView) itemView.findViewById(R.id.Descripcion);
            Descripcion=(TextView) itemView.findViewById(R.id.Direccion);
        }

        public TextView getDireccion(){
            return Direccion;
        }

        public TextView getDescripcion() {
            return Descripcion;
        }
    }
}

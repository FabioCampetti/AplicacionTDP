package com.example.tentissimo;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tentissimo.Activitys.DatosPedidoActivity;
import com.example.tentissimo.Activitys.PedidosActivity;

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
        final Pedido pedido= lista.get(position);
        final int pos=position;
        holder.getDescPedido().setText("Pedido #"+pedido.getCodigo());
        holder.getPrecioPedido().setText("$"+pedido.getPrecio());
        holder.getDireccion().setText(pedido.getDireccion());
        holder.getDescPedido().setBackgroundColor(Color.parseColor(pedido.getColor()));
        holder.getPrecioPedido().setBackgroundColor(Color.parseColor(pedido.getColor()));
        holder.getDireccion().setBackgroundColor(Color.parseColor(pedido.getColor()));
        holder.getDescPedido().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context, DatosPedidoActivity.class);
                intent.putExtra("codPedido",pedido.getCodigo());
                notifyItemChanged(pos);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView Direccion;
        private TextView descPedido;
        private TextView precioPedido;
        public ViewHolder(View itemView){
            super(itemView);
            Direccion=(TextView) itemView.findViewById(R.id.Direccion);
            precioPedido=(TextView) itemView.findViewById(R.id.precioPedido);
            descPedido=(TextView) itemView.findViewById(R.id.DescPedido);
        }

        public TextView getDireccion(){
            return Direccion;
        }

        public TextView getPrecioPedido() {
            return precioPedido;
        }

        public TextView getDescPedido(){ return descPedido;}

    }
}

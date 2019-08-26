package com.example.tentissimo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tentissimo.Productos.Producto;

import java.util.ArrayList;
import java.util.Map;

public class AdapterProductoPedido extends RecyclerView.Adapter<AdapterProductoPedido.ViewHolder> {
    private Stock stock=Stock.getInstance();
    private Map<Producto,Integer> productos;
    private ArrayList<Producto> listaProductos;
    private Map<String,Map<String,Integer>> productosElegidos;
    private Context context;
    private String producto;
    private View.OnClickListener sumar;
    private View.OnClickListener restar;

    public AdapterProductoPedido(String producto,Map<String,Map<String,Integer>> productosElegidos,Context context){
        this.context = context;
        this.producto = producto;
        this.productosElegidos=productosElegidos;
        productos=stock.getStockProducto(producto);
        listaProductos=(ArrayList<Producto>) stock.getListaStockProducto(producto);
    }

    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.producto_pedido, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder (@NonNull ViewHolder holder, int position) {
        Producto p = listaProductos.get(position);
        String prodEspecifico = p.getNombre();
        holder.getProducto().setText(prodEspecifico);
        holder.getCantidad().setText(String.valueOf(productosElegidos.get(producto).get(prodEspecifico)));
        holder.getRestar().setOnClickListener(restar);
        holder.getSumar().setOnClickListener(sumar);
    }
    public void aumentar(View view){
        TextView nombre= (TextView) view.findViewById(R.id.Cantidad);
        TextView cant= (TextView) view.findViewById(R.id.Cantidad);


    }


    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView producto;
        private TextView cantidad;
        private ImageButton sumar;
        private ImageButton restar;

        public ViewHolder(View itemView){
            super(itemView);
            producto=(TextView) itemView.findViewById(R.id.Nombre);
            cantidad=(TextView) itemView.findViewById(R.id.Cantidad);
            sumar=(ImageButton) itemView.findViewById(R.id.imageButton2);
            restar=(ImageButton) itemView.findViewById(R.id.imageButton7);
        }

        public TextView getCantidad() {
            return cantidad;
        }

        public TextView getProducto() {
            return producto;
        }

        public ImageButton getRestar() {
            return restar;
        }

        public ImageButton getSumar() {
            return sumar;
        }


    }
}

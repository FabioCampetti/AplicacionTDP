package com.example.tentissimo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
    private TextView cantidadProductos;
    private TextView totalPrecio;

    public AdapterProductoPedido(String producto,Map<String,Map<String,Integer>> productosElegidos,Context context,TextView cantidad,TextView total){
        this.context = context;
        this.producto = producto;
        this.productosElegidos=productosElegidos;
        productos=stock.getStockProducto(producto);
        listaProductos=(ArrayList<Producto>) stock.getListaStockProducto(producto);
        cantidadProductos=cantidad;
        totalPrecio=total;
    }

    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.producto_pedido, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder (@NonNull ViewHolder holder, int position) {
        final Producto p = listaProductos.get(position);
        final String prodEspecifico = p.getNombre();
        holder.getProducto().setText(prodEspecifico);
        holder.getCantidad().setText(String.valueOf(productosElegidos.get(producto).get(prodEspecifico)));
        holder.getRestar().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(productosElegidos.get(producto).get(prodEspecifico)>0)
                {productosElegidos.get(producto).put(prodEspecifico,productosElegidos.get(producto).get(prodEspecifico)-1);
                notifyDataSetChanged();
                int newCant=Integer.parseInt(cantidadProductos.getText().toString());
                newCant--;
                cantidadProductos.setText(newCant+"");
                int precio=Integer.parseInt(totalPrecio.getText().toString());
                precio-=p.getPrecio();
                totalPrecio.setText(precio+"");}
            }
        });
        holder.getSumar().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(stock.getCantidadProdcuto(producto,prodEspecifico)>productosElegidos.get(producto).get(prodEspecifico))
                {productosElegidos.get(producto).put(prodEspecifico,productosElegidos.get(producto).get(prodEspecifico)+1);
                notifyDataSetChanged();
                int newCant=Integer.parseInt(cantidadProductos.getText().toString());
                newCant++;
                cantidadProductos.setText(newCant+"");
                int precio=Integer.parseInt(totalPrecio.getText().toString());
                precio+=p.getPrecio();
                totalPrecio.setText(precio+"");}
                else
                    Toast.makeText(context,"Stock Insuficiente", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void sumar(ViewHolder view){

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

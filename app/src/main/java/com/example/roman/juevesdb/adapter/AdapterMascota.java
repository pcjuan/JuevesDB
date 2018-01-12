package com.example.roman.juevesdb.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.roman.juevesdb.R;
import com.example.roman.juevesdb.modelo.CrudMascota;
import com.example.roman.juevesdb.modelo.Mascota;

import java.util.List;

/**
 * Created by roman on 11-01-18.
 */

public class AdapterMascota extends RecyclerView.Adapter<AdapterMascota.MascotaViewHolder>{

    private List<Mascota> lista;
    private int resource;
    private Activity activity;

    public AdapterMascota(List<Mascota> lista, int resource, Activity activity) {
        this.lista = lista;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).
                inflate(resource,parent,false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        Mascota m = lista.get(position);
        holder.itemId.setText(String.valueOf(m.getId()));
        holder.itemNombre.setText(m.getNombre());
        holder.itemRaza.setText(m.getRaza());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MascotaViewHolder extends RecyclerView.ViewHolder{
        private TextView itemNombre, itemRaza,itemId;
        private ImageView itemTrash;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            itemNombre = itemView.findViewById(R.id.item_nombre);
            itemRaza = itemView.findViewById(R.id.item_raza);
            itemId = itemView.findViewById(R.id.item_id);
            itemTrash = itemView.findViewById(R.id.item_trash);

            itemTrash.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    eliminar(Integer.parseInt(itemId.getText().toString()));
                    //esta instruccion actualiza el recyclerView
                    notifyDataSetChanged();
                }
            });
        }

        public void eliminar(int id){
            CrudMascota crud = new CrudMascota(itemView.getContext());
            crud.eliminar(id);
            lista = crud.mascotaList();
        }
    }

}















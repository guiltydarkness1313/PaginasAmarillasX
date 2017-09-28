package com.shibuyaxpress.paginasamarillas;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shibuyaxpress.paginasamarillas.models.Empresa;

import java.util.List;

/**
 * Created by paulf on 28-Sep-17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {
    private List<Empresa> itemList;
    private Context context;
    private TextView resultado;

    public RecyclerViewAdapter(Context context, List<Empresa> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_resultado, parent,false);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.nombreEmpresa.setText(itemList.get(position).getNombre());
        holder.direccionEmpresa.setText(itemList.get(position).getDireccion());
        holder.telefonoEmpresa.setText(itemList.get(position).getTelefono());
        //holder.imagenEmpresa.setImageResource(itemList.get(position).getLogo());
        Glide.with(context).load(itemList.get(position).getLogo()).into(holder.imagenEmpresa);
        holder.root.setTag(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public Empresa getItem(int position){
        return itemList.get(position);
    }
}

package com.example.myproperty;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private LayoutInflater inflater;
    private String[] sDaerah;
    private String[] sHarga;

    Adapter(Context context, String[] daerah_, String[] harga_){
        this.inflater = LayoutInflater.from(context);
        this.sDaerah = daerah_;
        this.sHarga = harga_;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.home_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String daerah = sDaerah[i];
        String harga = sHarga[i];
        viewHolder.daerahProperti.setText(daerah);
        viewHolder.hargaProperti.setText(harga);
    }

    @Override
    public int getItemCount() {
        return sDaerah.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView daerahProperti, hargaProperti;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            daerahProperti = itemView.findViewById(R.id.daerahProperti);
            hargaProperti = itemView.findViewById(R.id.hargaProperti);
        }
    }
}

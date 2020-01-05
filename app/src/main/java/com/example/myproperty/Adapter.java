package com.example.myproperty;

import android.content.Context;
import android.content.Intent;
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
    private String[] sJenis;

    Adapter(Context context, String[] daerah_, String[] harga_, String[] jenis_){
        this.inflater = LayoutInflater.from(context);
        this.sDaerah = daerah_;
        this.sHarga = harga_;
        this.sJenis = jenis_;
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
        String jenis = sJenis[i];
        viewHolder.daerahProperti.setText(daerah);
        viewHolder.hargaProperti.setText(harga);
        viewHolder.jenisProperti.setText(jenis);
    }

    @Override
    public int getItemCount() {
        return sDaerah.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView daerahProperti, hargaProperti, jenisProperti;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(),DetailProperty.class);
                    i.putExtra("namaDaerah",sDaerah[getAdapterPosition()]);
                    i.putExtra("namaHarga",sHarga[getAdapterPosition()]);
                    v.getContext().startActivity(i);
                }
            });
            daerahProperti = itemView.findViewById(R.id.daerahProperti);
            hargaProperti = itemView.findViewById(R.id.hargaProperti);
            jenisProperti = itemView.findViewById(R.id.jenisProperti);
        }
    }
}

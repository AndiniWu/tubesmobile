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
    private String[] sKt;
    private String[] sKm;
    private String[] sLt;
    private String[] sLb;
    private String[] sFasilitas;
    private String[] sAlamat;
    private String[] sTelepon;
    private String[] sSurel;

    Adapter(Context context, String[] daerah_, String[] harga_, String[] jenis_, String[] kt_,
            String[] km_, String[] lt_, String[] lb_, String[] fasilitas_, String[] alamat_,
            String[] telepon_, String[] surel_){
        this.inflater = LayoutInflater.from(context);
        this.sDaerah = daerah_;
        this.sHarga = harga_;
        this.sJenis = jenis_;
        this.sKt = kt_;
        this.sKm = km_;
        this.sLt = lt_;
        this.sLb = lb_;
        this.sFasilitas = fasilitas_;
        this.sAlamat = alamat_;
        this.sTelepon = telepon_;
        this.sSurel = surel_;
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
        String kt = sKt[i];
        String km = sKm[i];
        String lt = sLt[i];
        String lb = sLb[i];
        String fasilitas = sFasilitas[i];
        String alamat = sAlamat[i];
        String telepon = sTelepon[i];
        String surel = sSurel[i];
        viewHolder.daerahProperti.setText(daerah);
        viewHolder.hargaProperti.setText(harga);
        viewHolder.jenisProperti.setText(jenis);
        viewHolder.ktProperti.setText(kt);
        viewHolder.kmProperti.setText(km);
        viewHolder.ltProperti.setText(lt);
        viewHolder.lbProperti.setText(lb);
        viewHolder.fasilitasProperti.setText(fasilitas);
        viewHolder.alamatProperti.setText(alamat);
        viewHolder.teleponProperti.setText(telepon);
        viewHolder.surelProperti.setText(surel);
    }

    @Override
    public int getItemCount() {
        return sDaerah.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView daerahProperti, hargaProperti, jenisProperti, ktProperti, kmProperti,
                ltProperti, lbProperti, fasilitasProperti, alamatProperti, teleponProperti, surelProperti;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(),DetailProperty.class);
                    i.putExtra("namaDaerah",sDaerah[getAdapterPosition()]);
                    i.putExtra("namaHarga",sHarga[getAdapterPosition()]);
                    i.putExtra("namaJenis",sJenis[getAdapterPosition()]);
                    i.putExtra("namaKt",sKt[getAdapterPosition()]);
                    i.putExtra("namaKm",sKm[getAdapterPosition()]);
                    i.putExtra("namaLt",sLt[getAdapterPosition()]);
                    i.putExtra("namaLb",sLb[getAdapterPosition()]);
                    i.putExtra("namaFasilitas",sFasilitas[getAdapterPosition()]);
                    i.putExtra("namaAlamat",sAlamat[getAdapterPosition()]);
                    i.putExtra("namaTelepon",sTelepon[getAdapterPosition()]);
                    i.putExtra("namaSurel",sSurel[getAdapterPosition()]);
                    v.getContext().startActivity(i);
                }
            });
            daerahProperti = itemView.findViewById(R.id.daerahProperti);
            hargaProperti = itemView.findViewById(R.id.hargaProperti);
            jenisProperti = itemView.findViewById(R.id.jenisProperti);
            ktProperti = itemView.findViewById(R.id.ktProperti);
            kmProperti = itemView.findViewById(R.id.kmProperti);
            ltProperti = itemView.findViewById(R.id.ltProperti);
            lbProperti = itemView.findViewById(R.id.lbProperti);
            fasilitasProperti = itemView.findViewById(R.id.fasilitasProperti);
            alamatProperti = itemView.findViewById(R.id.alamatProperti);
            teleponProperti = itemView.findViewById(R.id.teleponProperti);
            surelProperti = itemView.findViewById(R.id.surelProperti);
        }
    }
}

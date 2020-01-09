package com.example.myproperty;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

    private ArrayList<ModelEditProp> daftarProperty;
    private Context context;
    FirebaseDataListener listener;

    public AdapterRecyclerView(ArrayList<ModelEditProp> properties, Context ctx){
        /**
         * Inisiasi data dan variabel yang akan digunakan
         */
        daftarProperty = properties;
        context = ctx;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * Inisiasi View
         * kita hanya menggunakan data String untuk tiap item
         * dan juga view nya hanyalah satu TextView
         */
        TextView tvTitle;
        TextView tvPrice;
        TextView tvType;
        ImageView tvImage;
        CardView cvMain;

        ViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tv_title);
            tvPrice = (TextView) v.findViewById(R.id.tv_price);
            tvType = (TextView) v.findViewById(R.id.tv_type);
            cvMain = (CardView) v.findViewById(R.id.cv_main);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         *  Inisiasi ViewHolder
         */
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_property, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        /**
         *  Menampilkan data pada view
         */

        //final String harga = daftarProperty.get(position).getHargaET();
        //final String alamat = daftarProperty.get(position).getAlamatET();
        //inal String tipe = daftarProperty.get(position).getTipePropET();

        System.out.println("Data Property "+position+daftarProperty.size());
        holder.cvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(ReadSingleActivity.getActIntent((Activity) context).putExtra("data", daftarProperty.get(position)));
            }
        });
        holder.cvMain.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Delete dan update data
                 */
                return true;
            }
        });
        //holder.tvTitle.setText(alamat);
        //holder.tvPrice.setText(harga);
        //holder.tvType.setText(tipe);
        holder.tvTitle.setText(daftarProperty.get(position).getDaerahET());
        holder.tvPrice.setText(daftarProperty.get(position).getHargaET());
        holder.tvType.setText(daftarProperty.get(position).getTipePropET());
    }

    @Override
    public int getItemCount() {
        /**
         * Mengembalikan jumlah item pada barang
         */
        return daftarProperty.size();
    }

    public interface FirebaseDataListener{
        void onDeleteData(ModelEditProp modelProp, int position);
    }
}
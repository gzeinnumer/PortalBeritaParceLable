package com.gzeinnumer.portalberita.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gzeinnumer.portalberita.BuildConfig;
import com.gzeinnumer.portalberita.detail.Detail;
import com.gzeinnumer.portalberita.R;
import com.gzeinnumer.portalberita.model.BeritaItem;
import com.squareup.picasso.Picasso;

import java.util.List;

//todo 7.buat adapter
public class AdapterBerita extends RecyclerView.Adapter<AdapterBerita.MyHolder>{
    private Context mContex;
    private List<BeritaItem> mList;

    public AdapterBerita(Context mContex, List<BeritaItem> mList) {
        this.mContex = mContex;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        todo 9.hubungkan
        View view = LayoutInflater.from(mContex).inflate(R.layout.item, viewGroup, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, final int i) {
//        todo 10. isi
        Picasso.get().load(
                BuildConfig.BASE_URL+"images/"+mList.get(i).getFoto())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.ic_launcher_background)
                .into(myHolder.gambarBeritaList);
        myHolder.namaBeritaList.setText(mList.get(i).getJudulBerita());
        myHolder.penulisBeritaList.setText(mList.get(i).getPenulis());
        myHolder.tanggalBeritaList.setText(mList.get(i).getTanggalPosting());
        myHolder.cardBeritaList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                todo 12.
                Intent intent = new Intent(mContex, Detail.class);
                BeritaItem data = new BeritaItem(
                        mList.get(i).getPenulis(),
                        mList.get(i).getFoto(),
                        mList.get(i).getId(),
                        mList.get(i).getJudulBerita(),
                        mList.get(i).getTanggalPosting(),
                        mList.get(i).getIsiBerita()                        );
                intent.putExtra("data",data);
                mContex.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        CardView cardBeritaList;
        ImageView gambarBeritaList;
        TextView namaBeritaList,penulisBeritaList,tanggalBeritaList;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            gambarBeritaList = itemView.findViewById(R.id.gambarBeritaList);
            namaBeritaList = itemView.findViewById(R.id.namaBeritaList);
            penulisBeritaList = itemView.findViewById(R.id.penulisBeritaList);
            tanggalBeritaList = itemView.findViewById(R.id.tanggalBeritaList);
            cardBeritaList = itemView.findViewById(R.id.cardView);
        }
    }
}

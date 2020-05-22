package com.muneiah.android2020;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    Context context;
    String titiles[];

    public MainAdapter(Context context, String[] titiles) {
        this.context = context;
        this.titiles = titiles;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.main_recycler_design,parent,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
holder.data.setText(titiles[position]);
    }

    @Override
    public int getItemCount() {
        return titiles.length;
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        TextView data;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            data=itemView.findViewById(R.id.tv_main_rec_titile);
        }
    }
}

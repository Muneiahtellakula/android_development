package com.muneiah.android2020.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.muneiah.android2020.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    RecyclerViewDemo recyclerViewDemo;
    int pic[];
    String tname[],tex[],tquli[];

    public RecyclerAdapter(RecyclerViewDemo recyclerViewDemo, int[] pic, String[] tname, String[] tex, String[] tquli) {
        this.recyclerViewDemo = recyclerViewDemo;
        this.pic = pic;
        this.tname = tname;
        this.tex = tex;
        this.tquli = tquli;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(recyclerViewDemo).inflate(R.layout.row_recyclerdesign,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.ex.setText(""+tex[position]);
        holder.name.setText(""+tname[position]);
        holder.qulif.setText(""+tquli[position]);
        holder.img.setImageResource(pic[position]);
    }

    @Override
    public int getItemCount() {
        return tname.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name,qulif,ex;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.imageView2);
            name=itemView.findViewById(R.id.textView4);
            qulif=itemView.findViewById(R.id.textView5);
            ex=itemView.findViewById(R.id.textView6);
        }
    }
}

package com.muneiah.android2020.RecyclerDiffUtil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.muneiah.android2020.R;

import java.util.List;

public class DiffAdapter extends RecyclerView.Adapter<DiffAdapter.DiffViewHolder> {
    RecyclerDiffUtilActivity context;
    List<DataDiffModelClass> diffModelClassList;

    public DiffAdapter(RecyclerDiffUtilActivity context, List<DataDiffModelClass> diffModelClassList) {
        this.context = context;
        this.diffModelClassList = diffModelClassList;
    }

    @NonNull
    @Override
    public DiffAdapter.DiffViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.diffutil_layout_design,parent,false);
        return new DiffViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiffAdapter.DiffViewHolder holder, int position) {
        /*holder.i.setText(diffModelClassList.get(position).id);
        holder.t.setText(diffModelClassList.get(position).name);*/
        holder.i.setText(diffModelClassList.get(position).getId());
        holder.t.setText(diffModelClassList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return diffModelClassList.size();
    }

    public class DiffViewHolder extends RecyclerView.ViewHolder {
        TextView i,t;
        public DiffViewHolder(@NonNull View itemView) {
            super(itemView);
            i=itemView.findViewById(R.id.diff_id);
            t=itemView.findViewById(R.id.diff_name);
        }
    }
}

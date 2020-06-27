package com.muneiah.android2020.RecyclerDiffUtil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.muneiah.android2020.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerDiffUtilActivity extends AppCompatActivity {
RecyclerView recyclerView;
DiffAdapter adapter;
List<DataDiffModelClass> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_diff_util);
        recyclerView=findViewById(R.id.diff_rec);
        list=new ArrayList<>();
        adapter=new DiffAdapter(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }

    public void addData(View view) {

    }
}

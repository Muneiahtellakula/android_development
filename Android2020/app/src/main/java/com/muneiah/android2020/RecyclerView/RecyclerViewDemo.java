package com.muneiah.android2020.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.muneiah.android2020.R;

public class RecyclerViewDemo extends AppCompatActivity {
    int profilePis[];
    String names[], desig[], expr[];
RecyclerView rv;
RecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        rv=findViewById(R.id.recyclerview_rv);
        names = getResources().getStringArray(R.array.team_names);
        expr = getResources().getStringArray(R.array.exprence);
        desig = getResources().getStringArray(R.array.qulification);
        profilePis = new int[]{R.drawable.anusha,
                R.drawable.chaithanya, R.drawable.gopal, R.drawable.krishna, R.drawable.masthan,
                R.drawable.muni, R.drawable.pavan, R.drawable.ramireddy, R.drawable.sai, R.drawable.siva,
                R.drawable.vara};
        adapter=new RecyclerAdapter(this,profilePis,names,expr,desig);

        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}

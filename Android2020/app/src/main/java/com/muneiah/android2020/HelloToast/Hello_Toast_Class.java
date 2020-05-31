package com.muneiah.android2020.HelloToast;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.muneiah.android2020.R;

public class Hello_Toast_Class extends AppCompatActivity {
    TextView label;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_activity_toast);
        label=findViewById(R.id.tv_count);


    }

    public void showToast(View view) {
        Toast.makeText(this, "The Count is : "+label.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    public void showCount(View view) {
        count++;
        label.setText(String.valueOf(count));
    }
}

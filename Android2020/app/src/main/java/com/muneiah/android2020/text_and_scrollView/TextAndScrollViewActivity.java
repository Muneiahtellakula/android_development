package com.muneiah.android2020.text_and_scrollView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.muneiah.android2020.R;

public class TextAndScrollViewActivity extends AppCompatActivity {
TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_and_scroll_view);
        t=findViewById(R.id.tv_scrollview);
        t.setText(R.string.text_scroll);
    }
}

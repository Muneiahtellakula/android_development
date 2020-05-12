package com.muneiah.android2020.Intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.muneiah.android2020.MainActivity;
import com.muneiah.android2020.R;

public class IntentsActivity extends AppCompatActivity {
TextView label_result;
Button send,web;
EditText msgInput,webInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents);
        //life cycle Activity
        Toast.makeText(this, "App Created()", Toast.LENGTH_SHORT).show();
        send=findViewById(R.id.sendbtnn);
        web=findViewById(R.id.webbtn);
        msgInput=findViewById(R.id.et);
        webInput=findViewById(R.id.et_eb);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg=msgInput.getText().toString();
               Intent intent=new Intent(getApplicationContext(), MainActivity.class);
               intent.putExtra("key",msg);
                startActivity(intent);
            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=webInput.getText().toString();
                Uri uri = Uri.parse("http://www."+url+".com");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(it);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "App started()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "App resumed()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "App paused()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "App stopped()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "App destroyed()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "App restarted()", Toast.LENGTH_SHORT).show();
    }
}

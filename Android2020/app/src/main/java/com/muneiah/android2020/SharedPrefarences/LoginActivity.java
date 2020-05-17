package com.muneiah.android2020.SharedPrefarences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.muneiah.android2020.InputControls.InputControlActivity;
import com.muneiah.android2020.MainActivity;
import com.muneiah.android2020.R;


public class LoginActivity extends AppCompatActivity {
TextInputLayout nam,pass;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nam=findViewById(R.id.et_name);
        pass=findViewById(R.id.et_pss);
    }

    public void register(View view) {
        Intent intent=new Intent(this, InputControlActivity.class);
        startActivity(intent);
    }

    public void loginScreen(View view) {
        String mymob=nam.getEditText().getText().toString();
        String mypassword=pass.getEditText().getText().toString();
        sharedPreferences=getSharedPreferences("muni",MODE_PRIVATE);
       String sName= sharedPreferences.getString("uname","");
       String sPass= sharedPreferences.getString("upass","");
       if (mymob.equals(sName) && mypassword.equals(sPass)){
           Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
           Intent intent=new Intent(this, MainActivity.class);
           startActivity(intent);

       }
    }
}

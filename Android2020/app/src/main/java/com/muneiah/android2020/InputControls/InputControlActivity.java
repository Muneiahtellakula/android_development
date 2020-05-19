
package com.muneiah.android2020.InputControls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.muneiah.android2020.R;

public class InputControlActivity extends AppCompatActivity {
RatingBar ratingBar;
SeekBar seekBar;
TextInputLayout nam,pas,mail,mob;
TextView t;
RadioButton m,f;
CheckBox e;
CheckBox te;
CheckBox h;

String language;
String gender;
Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_control);
      init();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(InputControlActivity.this, "Progress is "+progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                Toast.makeText(InputControlActivity.this, "Rating "+rating, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        ratingBar=findViewById(R.id.rb);
        seekBar=findViewById(R.id.seek);
        t=findViewById(R.id.tvresult);
        nam=findViewById(R.id.name);
        mail=findViewById(R.id.email);
        mob=findViewById(R.id.mobile);
        pas=findViewById(R.id.password);
        m=findViewById(R.id.radioButton_m);
        f=findViewById(R.id.radioButton_f);
        spinner=findViewById(R.id.spin);
        e=findViewById(R.id.checkBox_e);
        h=findViewById(R.id.checkBox_h);
        te=findViewById(R.id.checkBox_t);

    }

    public void submitValues(View view) {
        int noofstars = ratingBar.getNumStars();
        float getrating = ratingBar.getRating();

        Toast.makeText(this, "Rating: "+getrating+"/"+noofstars, Toast.LENGTH_SHORT).show();
        String bran=spinner.getSelectedItem().toString();
        if(m.isChecked()){
            gender="m";
        }else if(f.isChecked()){
            gender="f";
        }
        if (h.isChecked()){
            language="Hindi";
        } if (te.isChecked()){
            language=language+"\t"+"Telugu";
        } if (e.isChecked()){
            language=language+"\t"+"English";
        }

        String myname=nam.getEditText().getText().toString();
        String mymail=mail.getEditText().getText().toString();
        String mymob=mob.getEditText().getText().toString();
                t.setText("Rating: "+getrating+"/"+noofstars+"\n"+myname+"\n"+mymail
                +"\n\n"+mymob+"\n"+language+"\n"+gender);

    }
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences=getSharedPreferences("muni",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("uname",nam.getEditText().getText().toString());
        editor.putString("upass",pas.getEditText().getText().toString());
        editor.commit();

    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences=getSharedPreferences("muni",MODE_PRIVATE);
        String ss=sharedPreferences.getString("uname","");
        String pp=sharedPreferences.getString("upass","");
        Toast.makeText(this, " Shared "+ss + pp, Toast.LENGTH_SHORT).show();

    }
}

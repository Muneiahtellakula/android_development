package com.muneiah.android2020.AlarmManger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.muneiah.android2020.R;

public class AlarmActivity extends AppCompatActivity {
ImageView bt1;
int a=0;
ToggleButton toggleButton;
AlarmManager alarmManager;
PendingIntent pendingIntent;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        bt1=findViewById(R.id.btn1);
        intent=new Intent(this,MyReceiver.class);
        pendingIntent=PendingIntent.getBroadcast(this,24,intent,PendingIntent.FLAG_UPDATE_CURRENT);
      //  bt2=findViewById(R.id.btn2);
       // bt2.setVisibility(View.INVISIBLE);
        alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
        toggleButton=findViewById(R.id.tg);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    long tiggertime= SystemClock.elapsedRealtime()+1*60*1000;
                    long intervel=1*60*1000;
                    alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,tiggertime,intervel,pendingIntent);
                    Toast.makeText(AlarmActivity.this, "on state", Toast.LENGTH_SHORT).show();
                }else {
                    alarmManager.cancel(pendingIntent);
                    Toast.makeText(AlarmActivity.this, "off state", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void play(View view) {
        if (a==0) {
            bt1.setImageResource(R.drawable.sai);

            Intent intent = new Intent(this, MyAlarmService.class);
            startService(intent);
            a++;
            //bt2.setVisibility(View.VISIBLE);
        }else if (a>0){
           bt1.setImageResource(R.drawable.muni);
            Intent intent=new Intent(this,MyAlarmService.class);
            stopService(intent);
            a--;
        }
    }

    /*public void pause(View view) {
        bt1.setVisibility(View.INVISIBLE);

    }*/
}

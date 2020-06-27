package com.muneiah.android2020.AlarmManger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

public class MyReceiver extends BroadcastReceiver {
MediaPlayer mediaPlayer;
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        mediaPlayer.start();
       // throw new UnsupportedOperationException("Not yet implemented");

    }
}

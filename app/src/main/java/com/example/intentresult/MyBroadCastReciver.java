package com.example.intentresult;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.widget.Toast;

public class MyBroadCastReciver extends BroadcastReceiver {
    MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent) {
        mp.setAudioStreamType(AudioManager.STREAM_ALARM);
        mp=MediaPlayer.create(context,R.raw.heal);

       mp.start();
        Toast.makeText(context, "Alarm....", Toast.LENGTH_LONG).show();
    }
}

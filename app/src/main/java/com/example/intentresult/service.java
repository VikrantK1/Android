package com.example.intentresult;

import android.app.Activity;
import android.app.Service;
import android.bluetooth.BluetoothClass;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class service extends Service {


    MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
        mediaPlayer = MediaPlayer.create(this, R.raw.heal);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

    }


    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
        mediaPlayer.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}

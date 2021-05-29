package com.example.broadcastrecive23032021;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class MyBroadCast  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
            if (Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0) {
                Toast.makeText(context, "Plane Mode : ON", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Plane Mode : OFF", Toast.LENGTH_SHORT).show();
            }
        }


    }
}

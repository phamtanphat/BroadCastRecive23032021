package com.example.broadcastrecive23032021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    TextView mTvAirPlaneMode;
    MyBroadCast mMyBroadCast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvAirPlaneMode = findViewById(R.id.textView);
        mMyBroadCast = new MyBroadCast();
    }

    @Override
    public void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(mMyBroadCast,intentFilter);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        unregisterReceiver(mMyBroadCast);
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent mes) {
        boolean enablePlaneMode = mes.isEnablePlaneMode();
        mTvAirPlaneMode.setText("Chế độ máy bay : " + (enablePlaneMode ? "ON" : "OFF"));
    };

}
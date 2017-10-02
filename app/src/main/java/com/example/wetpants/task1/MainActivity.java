package com.example.wetpants.task1;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(2000, 1000)  {

            public void onTick(long m) {

            }

            public void onFinish() {

            }
        }.start();

        Intent intent = new Intent(MainActivity.this, TimerActivity.class);
        startActivity(intent);
    }
}

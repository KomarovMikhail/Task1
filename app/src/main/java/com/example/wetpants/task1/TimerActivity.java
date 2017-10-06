package com.example.wetpants.task1;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    private Button button;
    private TextView text;
    private boolean started = false;
    private Timer timer;
    private Worker worker;
    private long savedTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        button = (Button)findViewById(R.id.button);
        text = (TextView)findViewById(R.id.text);
        timer = new Timer(1000000, 1000, text);

//        if (started) {
//            text.setText(timer.getStringTime());
//        } else {
//            worker = new Worker(timer, text, button, started);
//            worker.run();
//        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (started) {
                    button.setText(R.string.button_start);
                    text.setText("");
                    started = false;
                    timer.cancel();

                } else {
                    button.setText(R.string.button_stop);
                    started = true;
                    timer.start();
                }
            }
        });


    }



}

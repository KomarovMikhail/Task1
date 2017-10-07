package com.example.wetpants.task1;

import android.app.Fragment;
import android.app.FragmentManager;
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
    //private Worker worker;
    private long savedTime = 0;
    private RetainedFragment dataFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        FragmentManager fm = getFragmentManager();
        dataFragment = (RetainedFragment) fm.findFragmentByTag("data");

        if (dataFragment == null) {
            dataFragment = new RetainedFragment();
            fm.beginTransaction().add(dataFragment, "data").commit();
            Data data = new Data(started, savedTime);
            dataFragment.setData(data);
        }

        Data data = new Data(dataFragment.getData());
        started = data.getStarted();
        savedTime = data.getSavedTime();

        button = (Button)findViewById(R.id.button);
        text = (TextView)findViewById(R.id.text);
        if (started) {
            button.setText(R.string.button_stop);
            timer = new Timer(1000000 - savedTime, 1000, text, button);
            text.setText(timer.getStringTime());
            timer.start();
        } else {
            button.setText(R.string.button_start);
            savedTime = 0;
            timer = new Timer(1000000 - savedTime, 1000, text, button);
        }

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

    @Override
    protected void onDestroy() {
        Data data = new Data(started, timer.getTime());
        dataFragment.setData(data);
        super.onDestroy();

    }

}

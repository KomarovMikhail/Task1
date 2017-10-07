package com.example.wetpants.task1;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Worker extends  Thread {
    private Timer timer;
    private TextView text;
    private Button button;
    private boolean started;

    public Worker(Timer timer, TextView text, Button button, boolean started) {
        this.timer = timer;
        this.text = text;
        this.button = button;
        this.started = started;
    }

    public void run() {
        //timer = new Timer(1000000, 1000, text);

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

package com.example.wetpants.task1;

import android.app.FragmentManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicInteger;

public class TimerActivity extends AppCompatActivity {

    private Button button;
    private TextView text;
    private boolean started = false;
    //private Timer timer;
    private AtomicInteger savedTime = new AtomicInteger(0);
    private RetainedFragment dataFragment;
    //private Counter counter;
    private String stringTime = "";
    final private String digits[] = {"", "один", "два", "три", "четыре", "пять",
            "шесть", "семь", "восемь", "девять"};
    final private String decades[] = {"", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят",
            "семьдесят", "восемьдесят", "девяносто"};
    final private String teens[] = {"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
    final private String hundreds[] = {"", "сто", "двести", "триста", "четыреста", "пятьсот",
            "шестьсот", "семьсот", "восемьсот", "девятьсот"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        FragmentManager fm = getFragmentManager();
        dataFragment = (RetainedFragment) fm.findFragmentByTag("data");

        if (dataFragment == null) {
            dataFragment = new RetainedFragment();
            fm.beginTransaction().add(dataFragment, "data").commit();
            Data data = new Data(started, savedTime, stringTime);
            dataFragment.setData(data);
        }

        Data data = new Data(dataFragment.getData());
        started = data.getStarted();
        savedTime = data.getSavedTime();
        stringTime = data.getStringTime();
        //counter = data.getCounter();
//        if (counter == null) {
//            counter = new Counter();
//        }
        //counter = new Counter();
        //counter.link(this);

        button = (Button)findViewById(R.id.button);
        text = (TextView)findViewById(R.id.text);

        //new Counter().execute();

        if (started) {
            button.setText(R.string.button_stop);
            //timer = new Timer(1000000 - savedTime, 1000, text, button);
            setStringTime();
            text.setText(stringTime);
            new Counter(text).execute();
        } else {
            button.setText(R.string.button_start);
            savedTime.set(0);
            //timer = new Timer(1000000 - savedTime, 1000, text, button);
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (started) {
                    button.setText(R.string.button_start);
                    text.setText("");
                    started = false;
                    savedTime.set(1000);

                } else {
                    button.setText(R.string.button_stop);
                    started = true;
                    //counter = new Counter();
                    new Counter(text).execute();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        //counter.unLink();
        Data data = new Data(started, savedTime, stringTime);
        dataFragment.setData(data);
        super.onDestroy();

    }

    private void setStringTime() {
        int time = savedTime.get();
        if ((time % 100) / 10 == 1) {
            stringTime = hundreds[time / 100] + " " +
                    teens[time % 10];
        } else {
            stringTime = hundreds[time / 100] + " " +
                    decades[(time % 100) / 10] + " " +
                    digits[time % 10];
        }
    }

    private class Counter extends AsyncTask<Void, Void, Void> {
//        TimerActivity activity;
//
//        void link(TimerActivity act) {
//            activity = act;
//        }
//
//        void unLink() {
//            activity = null;
//        }
        private TextView textView;

        private Counter(TextView textView) {
            super();
            this.textView = textView;
        }

        @Override
        protected Void doInBackground(Void... unused) {
            int time = savedTime.get();
            while (time < 1000) {
                if ((time % 100) / 10 == 1) {
                    stringTime = hundreds[time / 100] + " " +
                            teens[time % 10];
                } else {
                    stringTime = hundreds[time / 100] + " " +
                            decades[(time % 100) / 10] + " " +
                            digits[time % 10];
                }
                publishProgress();
                SystemClock.sleep(1000);
                time = savedTime.addAndGet(1);
            }
            return (null);
        }

        @Override
        protected void onProgressUpdate(Void... unused) {
            super.onProgressUpdate(unused);
            textView.setText(stringTime);
        }

        @Override
        protected void onPostExecute(Void unused) {
            savedTime.set(0);
            stringTime = "";
            textView.setText(stringTime);
            button.setText(R.string.button_start);
        }
    }

}

package com.example.wetpants.task1;

import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

public class Timer extends CountDownTimer {

    private TextView text;
    private Button button;
    private long totalTime;
    private long passedTime;
    private long time;

    private String stringTime = "";
    private String digits[] = {"", "один", "два", "три", "четыре", "пять",
            "шесть", "семь", "восемь", "девять"};
    private String decades[] = {"", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят",
            "семьдесят", "восемьдесят", "девяносто"};
    private String teens[] = {"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
    private String hundreds[] = {"", "сто", "двести", "триста", "четыреста", "пятьсот",
            "шестьсот", "семьсот", "восемьсот", "девятьсот"};

    public Timer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.totalTime = millisInFuture;
    }

    public Timer(long millisInFuture, long countDownInterval,
                 TextView text, Button button, long passedTime) {
        super(millisInFuture, countDownInterval);
        this.passedTime = passedTime;
        this.time = passedTime;
        this.totalTime = millisInFuture;
        this.text = text;
        this.button = button;
        setStringTime(totalTime - passedTime);
    }

    @Override
    public void onTick(long m) {
        setStringTime(m);
    }

    @Override
    public void onFinish() {
        stringTime = "";
        text.setText(stringTime);
        button.setText(R.string.button_start);
    }

    public String getStringTime() {
        return stringTime;
    }

    public long getTime() {
        return time;
    }

    private void setStringTime(long m) {
        int currentTime = (int) (totalTime + passedTime - m) / 1000;
        if (currentTime >= 1000) {
            return;
        }
        if ((currentTime % 100) / 10 == 1) {
            stringTime = hundreds[currentTime / 100] + " " +
                    teens[currentTime % 10];
        } else {
            stringTime = hundreds[currentTime / 100] + " " +
                    decades[(currentTime % 100) / 10] + " " +
                    digits[currentTime % 10];
        }
        text.setText(stringTime);
        time = currentTime;
    }
}

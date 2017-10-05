package com.example.wetpants.task1;

import android.os.CountDownTimer;
import android.widget.TextView;

public class Timer extends CountDownTimer {

    private TextView text;
    private long totalTime;

    private String stringTime = "";
    private String digits[] = {"", "один", "два", "три", "четыре", "пять",
            "шесть", "семь", "восемь", "девять"};
    private String decades[] = {"", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят",
            "семьдесят", "восемьдесят", "девяносто"};
    private String teens[] = {"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать", "восемнадцать", "девятнадцать"};
    private String hundreds[] = {"", "сто", "двести", "триста", "четыреста", "пятьсот",
            "шестьсот", "семьсот", "восемьсот", "девятьсот"};

    public Timer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.totalTime = millisInFuture;
    }

    public Timer(long millisInFuture, long countDownInterval, TextView text) {
        super(millisInFuture, countDownInterval);
        this.totalTime = millisInFuture;
        this.text = text;
        text.setText(stringTime);
    }

    @Override
    public void onTick(long m) {
        int currentTime = (int) (totalTime - m) / 1000;
        if (currentTime >= 1000) {
            throw new RuntimeException("Time limit exhausted");
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
    }

    @Override
    public void onFinish() {

    }

    public String getStringTime() {
        return stringTime;
    }
}

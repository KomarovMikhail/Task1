package com.example.wetpants.task1;

import android.os.CountDownTimer;

/**
 * Created by wetpants on 02.10.17.
 */

public class Timer extends CountDownTimer {

    private String stringTime = "";
    private String digits[] = {"один", "два", "три", "четыре", "пять",
            "шесть", "семь", "восемь", "девять"};
    private String decades[] = {"двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят",
            "семьдесят", "восемьдесят", "девяносто"};
    private String teens[] = {"одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать", "восемнадцать", "девятнадцать"};
    private String handreds[] = {"сто", "двести", "триста", "четыреста", "пятьсот",
            "шестьсот", "семьсот", "восемьсот", "девятьсот"};

    public Timer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long m) {

    }

    @Override
    public void onFinish() {

    }

    public String getStringTime() {
        return stringTime;
    }
}

package com.example.wetpants.task1;

import java.util.concurrent.atomic.AtomicInteger;

public class Data {
    private boolean started;
    private AtomicInteger savedTime;
    private String stringTime;

    public Data(boolean started, AtomicInteger savedTime,
                String stringTime) {
        this.savedTime = savedTime;
        this.started = started;
        this.stringTime = stringTime;
    }

    public Data(Data data) {
        this.started = data.getStarted();
        this.savedTime = data.getSavedTime();
        this.stringTime =  data.getStringTime();
    }

    public boolean getStarted() {
        return started;
    }

    public AtomicInteger getSavedTime() {
        return savedTime;
    }

    public String getStringTime() {
        return stringTime;
    }

//    public TimerActivity.Counter getCounter() {
//        return counter;
//    }
}

package com.example.wetpants.task1;

public class Data {
    private boolean started;
    private long savedTime;

    public Data(boolean started, long savedTime) {
        this.savedTime = savedTime;
        this.started = started;
    }

    public Data(Data data) {
        this.started = data.getStarted();
        this.savedTime = data.getSavedTime();
    }

    public boolean getStarted() {
        return started;
    }

    public long getSavedTime() {
        return savedTime;
    }
}

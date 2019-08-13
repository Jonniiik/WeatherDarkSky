package com.eugeneponomarev.weatherdarksky.Model;

public class Datum {
    private int time;
    private int precipIntensity;
    private int precipProbability;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(int precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public int getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(int precipProbability) {
        this.precipProbability = precipProbability;
    }
}

package com.eugeneponomarev.weatherdarksky.Model;

public class MinutelyDatum {
    private long time;
    private double precipIntensity;
    private double precipProbability;
    private Double precipIntensityError;
    private PrecipType precipType;

    public MinutelyDatum() {
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(double precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
    }

    public Double getPrecipIntensityError() {
        return precipIntensityError;
    }

    public void setPrecipIntensityError(Double precipIntensityError) {
        this.precipIntensityError = precipIntensityError;
    }

    public PrecipType getPrecipType() {
        return precipType;
    }

    public void setPrecipType(PrecipType precipType) {
        this.precipType = precipType;
    }
}

package com.eugeneponomarev.weatherdarksky.Model;


public class Flags {
    private String[] sources;
    private double nearestStation;
    private String units;

    public Flags() {
    }

    public String[] getSources() {
        return sources;
    }

    public void setSources(String[] sources) {
        this.sources = sources;
    }

    public double getNearestStation() {
        return nearestStation;
    }

    public void setNearestStation(double nearestStation) {
        this.nearestStation = nearestStation;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}

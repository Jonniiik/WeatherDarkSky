package com.eugeneponomarev.weatherdarksky.Model;

import java.util.List;

public class Flags {
    private List<String> sources;
    private String invalid_name_meteoalarm_license;
    private double invalid_name_nearest_station;
    private String units;

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public String getInvalid_name_meteoalarm_license() {
        return invalid_name_meteoalarm_license;
    }

    public void setInvalid_name_meteoalarm_license(String invalid_name_meteoalarm_license) {
        this.invalid_name_meteoalarm_license = invalid_name_meteoalarm_license;
    }

    public double getInvalid_name_nearest_station() {
        return invalid_name_nearest_station;
    }

    public void setInvalid_name_nearest_station(double invalid_name_nearest_station) {
        this.invalid_name_nearest_station = invalid_name_nearest_station;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}

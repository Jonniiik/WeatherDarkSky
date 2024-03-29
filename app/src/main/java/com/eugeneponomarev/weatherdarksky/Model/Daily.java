package com.eugeneponomarev.weatherdarksky.Model;

import java.util.List;

public class Daily {
    private String summary;
    private String icon;
    private List<Datum3> data;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Datum3> getData() {
        return data;
    }

    public void setData(List<Datum3> data) {
        this.data = data;
    }
}

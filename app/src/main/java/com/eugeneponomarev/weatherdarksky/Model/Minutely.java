package com.eugeneponomarev.weatherdarksky.Model;

public class Minutely {
    private String summary;
    private Icon icon;
    private MinutelyDatum[] data;

    public Minutely() {
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public MinutelyDatum[] getData() {
        return data;
    }

    public void setData(MinutelyDatum[] data) {
        this.data = data;
    }
}

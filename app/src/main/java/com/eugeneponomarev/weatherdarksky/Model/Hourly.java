package com.eugeneponomarev.weatherdarksky.Model;

public class Hourly {
    private String summary;
    private Icon icon;
    private Currently[] data;

    public Hourly() {
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

    public Currently[] getData() {
        return data;
    }

    public void setData(Currently[] data) {
        this.data = data;
    }
}

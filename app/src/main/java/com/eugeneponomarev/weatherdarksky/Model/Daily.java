package com.eugeneponomarev.weatherdarksky.Model;


public class Daily {
    private String summary;
    private Icon icon;
    private DailyDatum[] data;

    public Daily() {
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

    public DailyDatum[] getData() {
        return data;
    }

    public void setData(DailyDatum[] data) {
        this.data = data;
    }
}

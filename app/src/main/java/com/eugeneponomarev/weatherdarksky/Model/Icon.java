package com.eugeneponomarev.weatherdarksky.Model;

import java.io.IOException;

public enum Icon {
    CLEAR_DAY, CLOUDY, PARTLY_CLOUDY_DAY, PARTLY_CLOUDY_NIGHT;

    public String toValue() {
        switch (this) {
            case CLEAR_DAY:
                return "clear-day";
            case CLOUDY:
                return "cloudy";
            case PARTLY_CLOUDY_DAY:
                return "partly-cloudy-day";
            case PARTLY_CLOUDY_NIGHT:
                return "partly-cloudy-night";
        }
        return null;
    }

    public static Icon forValue(String value) throws IOException {
        if (value.equals("clear-day")) return CLEAR_DAY;
        if (value.equals("cloudy")) return CLOUDY;
        if (value.equals("partly-cloudy-day")) return PARTLY_CLOUDY_DAY;
        if (value.equals("partly-cloudy-night")) return PARTLY_CLOUDY_NIGHT;
        throw new IOException("Cannot deserialize Icon");
    }
}

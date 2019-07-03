package com.eugeneponomarev.weatherdarksky.Model;

import java.io.IOException;

public enum PrecipType {
    RAIN;

    public String toValue() {
        switch (this) {
            case RAIN:
                return "rain";
        }
        return null;
    }

    public static PrecipType forValue(String value) throws IOException {
        if (value.equals("rain")) return RAIN;
        throw new IOException("Cannot deserialize PrecipType");
    }
}

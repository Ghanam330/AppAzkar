package com.example.appazkar.Model;

import java.io.Serializable;

public class Sabhe implements Serializable {
    public String azkarText;

    public Sabhe() {
    }

    public Sabhe(String azkarText) {
        this.azkarText = azkarText;
    }

    public String getAzkarText() {
        return azkarText;
    }

    public void setAzkarText(String azkarText) {
        this.azkarText = azkarText;
    }

}

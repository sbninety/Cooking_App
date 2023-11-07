package com.example.cooking_app.Model;

import java.io.Serializable;

public class Slider implements Serializable {
    private int sliderId;

    public int getSliderId() {
        return sliderId;
    }

    public void setSliderId(int sliderId) {
        this.sliderId = sliderId;
    }

    public Slider(int sliderId) {
        this.sliderId = sliderId;
    }
}

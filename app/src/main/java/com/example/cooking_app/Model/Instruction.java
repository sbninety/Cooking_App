package com.example.cooking_app.Model;

public class Instruction {
    private int step;
    private String decription;

    public Instruction(int step, String decription) {
        this.step = step;
        this.decription = decription;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }
}

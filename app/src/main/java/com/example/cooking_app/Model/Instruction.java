package com.example.cooking_app.Model;

public class Instruction {
    private int id;
    private int step;
    private String decription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Instruction() {
    }

    public Instruction(int id, int step, String decription) {
        this.id = id;
        this.step = step;
        this.decription = decription;
    }
}

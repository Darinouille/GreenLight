package com.example.greenlight;

public class Donnee extends SortieDonnee {
    // Valeur de 1 à 3
    private int value;

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    // Message affiché associé à la valeur
    private String message;

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
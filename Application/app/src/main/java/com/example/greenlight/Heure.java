package com.example.greenlight;

public class Heure extends SortieDonnee {
    // Le pas d'heure (de 0 à 23)
    private int pas;

    public int getPas() {
        return pas;
    }
    public void setPas(int pas) {
        this.pas = pas;
    }

    // La donnée pour l'heure
    private Donnee hvalue;

    public Donnee getHvalue() {
        return hvalue;
    }
    public void setHvalue(Donnee hvalue) {
        this.hvalue = hvalue;
    }

    // Constructeur
    public Heure(int pas, Donnee hvalue) {
        this.pas = pas;
        this.hvalue = hvalue;
    }

    public void affiche() {
        System.out.println(pas + "h : " + hvalue);
    }
}

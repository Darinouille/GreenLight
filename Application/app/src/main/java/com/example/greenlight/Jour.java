package com.example.greenlight;

// Pour pouvoir utiliser des types horodatage
import java.time.LocalDate;

public class Jour extends SortieDonnee {
    // La date du jour
    private LocalDate jour;

    public LocalDate getJour() {
        return jour;
    }
    public void setJour(LocalDate jour) {
        this.jour = jour;
    }

    // La donnée du jour
    private Donnee dvalue ;

    public Donnee getDvalue() {
        return dvalue;
    }
    public void setDvalue(Donnee dvalue) {
        this.dvalue = dvalue;
    }

    // Toutes les heures du jour
    private Heure[] listeHeure;

    public Heure[] getListeHeure() {
        return listeHeure;
    }
    public void setListeHeure(Heure[] listeHeure) {
        this.listeHeure = listeHeure;
    }

    // Constructeur
    public Jour(LocalDate jour, Donnee dvalue, Heure[] listeHeure) {
        this.jour = jour;
        this.dvalue = dvalue;
        this.listeHeure = listeHeure;
    }

    public void affiche() {
        System.out.println(jour + " : " + dvalue + " | " + listeHeure);
    }
}

package com.example.greenlight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    // On relie la variable java à l'objet graphique

    public void affDonnee(View v) {
        Jour jourJ;
        if dvalue.jourJ == 1 {
            img.setImageResource(R.drawable.france1);
        }
        
    }
}
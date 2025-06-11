package org.example.listeDesModels;

import org.example.model.Abonne;

import java.util.ArrayList;
import java.util.List;

public class ListeAbonnes {
    List<Abonne> abonnes = new ArrayList<>();
    public ListeAbonnes(){}
    public ListeAbonnes(List<Abonne> abonnes){
        this.abonnes = abonnes;
    }

    public List<Abonne> getAbonnes() {return abonnes;}

    public void setAbonnes(List<Abonne> abonnes) {this.abonnes = abonnes;}
}

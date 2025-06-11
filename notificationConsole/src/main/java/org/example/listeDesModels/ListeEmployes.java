package org.example.listeDesModels;

import org.example.model.Employe;

import java.util.ArrayList;
import java.util.List;

public class ListeEmployes {
    List<Employe> lesEmployes = new ArrayList<>();
    public ListeEmployes(){}
    public ListeEmployes(List<Employe> lesEmployes){
        this.lesEmployes = lesEmployes;
    }
    public List<Employe> getLesEmployes() {return lesEmployes;}

    public void setLesEmployes(List<Employe> lesEmployes) {
        this.lesEmployes = lesEmployes;
    }
}

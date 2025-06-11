package org.example.model;

public class Notification {
    String objet;
    String contenu;
    public  Notification(){}
    public Notification(String objet, String contenu){
        this.objet = objet;
        this.contenu = contenu;
    }
    public String getContenu() {return contenu;}

    public String getObjet() {return objet;}

    public void setContenu(String contenu) {this.contenu = contenu;}

    public void setObjet(String objet) {this.objet = objet;}

}

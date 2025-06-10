package org.example.model;

public class Abonne extends Employe{

    public Abonne(String prenom, String nom, String email, String password) {
        super(prenom, nom, email, password);
    }

    @Override
    public void setEstAbonne(boolean estAbonne) {
        super.setEstAbonne(true);
    }
    // les methodes de abonnes
    // methode afficher les notifications reçus
    public void afficherNotificationRecus(){

    }
    // la methode se desabonner à un service
    public void desabonnerServiceNotification(){

    }
}

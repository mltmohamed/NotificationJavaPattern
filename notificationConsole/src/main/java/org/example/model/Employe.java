package org.example.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.listeDesModels.ListeAbonnes;

import java.io.File;
import java.io.IOException;

public class Employe {
    String prenom;
    String nom;
    String email;
    String password;
    boolean estAbonne = false;
    // les getters
    public Employe(){}
    public Employe(String prenom, String nom, String email, String password){
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.password = password;
    }
    public String getPrenom() {return prenom;}
    public String getNom() {return nom;}
    public String getEmail() {return email;}
    public String getPassword() {return password;}
    public boolean getEstAbonne() {return estAbonne;}

    // les setters

    public void setPrenom(String prenom) {this.prenom = prenom;}
    public void setNom(String nom) {this.nom = nom;}
    public void setEmail(String email) {this.email = email;}
    public void setPassword(String password) {this.password = password;}
    public void setEstAbonne(boolean estAbonne) {this.estAbonne = estAbonne;}

    //Methode pour s'abonner à un service de notification
    public void AbonnerServiceNotification() throws IOException {

        File fichier = new File("lesAbonnes.json");
        File fichierEmploye = new File("lesEmployes.json");
        ObjectMapper mapper = new ObjectMapper();
        ListeAbonnes listesAbonnes = mapper.readValue(fichier, ListeAbonnes.class);
        Abonne abonne = new Abonne(this.prenom, this.nom, this.email, this.password);
        abonne.setEstAbonne(true);
        boolean resulat = false;
        for(Abonne abone : listesAbonnes.getAbonnes()){
            if(abone.getEmail().equals(this.email)){
                System.out.println("Vous êtes dejà abonné à un service de notification");
                resulat = true;
            }
        }
        if(!resulat){
            listesAbonnes.getAbonnes().add(abonne);
            abonne.setEstAbonne(true);
            mapper.writerWithDefaultPrettyPrinter().writeValue(fichier,listesAbonnes);
            System.out.println("Vous vous êtes abonné avec succès " + this.prenom + " "+ this.nom);
        }




    }
}

package org.example.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Interface.Message;
import org.example.listeDesModels.ListeAbonnes;
import org.example.listeDesModels.ListeNotification;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Abonne extends Employe implements Message {
    List<Notification> mesNotifications = new ArrayList<>();
    public Abonne(){}
    public Abonne(String prenom, String nom, String email, String password) {
        super(prenom, nom, email, password);
    }

    public List<Notification> getMesNotifications() {return mesNotifications;}

    public void setMesNotifications(List<Notification> mesNotifications) {
        this.mesNotifications = mesNotifications;
    }


    // les methodes de abonnes
    // methode afficher les notifications reçus
    public void afficherNotificationRecus() throws IOException{
        File fichier = new File("lesAbonnes.json");
        ObjectMapper mapper = new ObjectMapper();
        ListeAbonnes listesAbonnes = mapper.readValue(fichier, ListeAbonnes.class);
        ListeNotification notification = new ListeNotification();
        if(this.getMesNotifications().isEmpty()){
            System.out.println("Vous n'avez aucune notification");
        }
        else {
            notification.getListeNotification().addAll(this.getMesNotifications());
            for(Notification notif : notification.getListeNotification()){
                System.out.println("Voici vos notifications : ");
                System.out.println("Objet : " + notif.getObjet() + " Contenu : "+ notif.getContenu());
            }
        }


    }
    // la methode se desabonner à un service
    public void desabonnerServiceNotification() throws IOException {
        File fichier = new File("lesAbonnes.json");
        ObjectMapper mapper = new ObjectMapper();
        ListeAbonnes listesAbonnes = mapper.readValue(fichier, ListeAbonnes.class);
       Abonne abonne = new Abonne(this.getPrenom(),this.getNom(), this.getEmail(),this.getPassword());
        listesAbonnes.getAbonnes().remove(abonne);
        System.out.println(listesAbonnes.getAbonnes().size());
        mapper.writerWithDefaultPrettyPrinter().writeValue(fichier,listesAbonnes);
        System.out.println("Vous êtes desabonner avec succès " + this.prenom + " "+ this.nom);
        System.out.println(listesAbonnes.getAbonnes().size());
    }
    @Override
    public void envoyerNotification(String objet, String contenu) throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer l'objet du message : ");
        objet = scanner.nextLine();
        System.out.println("Entrer le contenu du message : ");
        contenu = scanner.nextLine();
        File fichier = new File("lesAbonnes.json");
        ObjectMapper mapper = new ObjectMapper();
        ListeAbonnes listesAbonnes = mapper.readValue(fichier, ListeAbonnes.class);
        for(Abonne abonne : listesAbonnes.getAbonnes()){
            if(abonne.getEmail().equals(this.getEmail())){
                continue;
            }
            else {
                Notification notification = new Notification(objet,contenu);
                abonne.getMesNotifications().add(notification);
                mapper.writerWithDefaultPrettyPrinter().writeValue(fichier,listesAbonnes);
                System.out.println("Message envoyé à " + abonne.getPrenom() + " " + abonne.getNom());
            }
        }
    }
    @Override
    public void envoyerEmail(String objet, String contenu){

    }

    // Aide de chatGPT ou reecrire la methode equals et hascode me permettant de supprimer de l'objet dans le json
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abonne abonne = (Abonne) o;
        return Objects.equals(prenom, abonne.prenom) &&
                Objects.equals(nom, abonne.nom) &&
                Objects.equals(email, abonne.email);
        // je peux aussi inclure le mot de passe si nécessaire
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenom, nom, email); // et password si je l’inclus dans equals
    }
}

package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.listeDesModels.ListeAbonnes;
import org.example.listeDesModels.ListeEmployes;
import org.example.model.Abonne;
import org.example.model.Employe;
import java.io.IOException;
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class AdminService {
    // methode ajouter un abonner
    public void ajouterAbonner() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        File fichierJsonEmploye = new File("lesEmployes.json");
        File fichierJsonAbonne = new File("lesAbonnes.json");
        Scanner scanner = new Scanner(System.in);
        ListeEmployes listesEmployes = mapper.readValue(fichierJsonEmploye,ListeEmployes.class);
        System.out.println("Entrer l'email de la personne  à être abonner");
        String email = scanner.nextLine();
        // verification si le fichier json Employe existe
        if (fichierJsonEmploye.exists() && fichierJsonEmploye.length() > 0){
            boolean resultat = false;
            for(Employe employe : listesEmployes.getLesEmployes()) {
                if (employe.getEmail().equals(email)) {
                    if(fichierJsonAbonne.exists() && fichierJsonAbonne.length() > 0){
                        resultat = true;
                        // dans le json je met à true est abonne l'employé et je met à jour le json
                        ListeEmployes listeEmployes = mapper.readValue(fichierJsonEmploye, ListeEmployes.class);
                        employe.setEstAbonne(true);
                        mapper.writerWithDefaultPrettyPrinter().writeValue(fichierJsonEmploye,listeEmployes);
                        // je cree un nouveau abonner et je met à jour dans le json abonnees
                        Abonne abonne = new Abonne(employe.getPrenom(),employe.getNom(),employe.getEmail(),employe.getPassword());
                        abonne.setEstAbonne(true);
                        ListeAbonnes listesAbonnes = mapper.readValue(fichierJsonAbonne,ListeAbonnes.class);
                        listesAbonnes.getAbonnes().add(abonne);
                        mapper.writerWithDefaultPrettyPrinter().writeValue(fichierJsonAbonne,listesAbonnes);
                        System.out.println("L'employé " + employe.getPrenom() + " " + employe.getNom() + " a été ajouter avec succès comme abonné !");
                    }
                    else if (fichierJsonAbonne.exists() && fichierJsonAbonne.length() == 0) {
                        resultat = true;
                        // dans le json je met à true est abonne l'employé et je met à jour le json
                        ListeEmployes listeEmployes = mapper.readValue(fichierJsonEmploye, ListeEmployes.class);
                        employe.setEstAbonne(true);
                        mapper.writerWithDefaultPrettyPrinter().writeValue(fichierJsonEmploye,listeEmployes);
                        // je cree un nouveau abonner et je met à jour dans le json abonnees
                        Abonne abonne = new Abonne(employe.getPrenom(),employe.getNom(),employe.getEmail(),employe.getPassword());
                        ListeAbonnes listesAbonnes  = new ListeAbonnes() ;
                        listesAbonnes.getAbonnes().add(abonne);
                        mapper.writerWithDefaultPrettyPrinter().writeValue(fichierJsonAbonne,listesAbonnes);
                        System.out.println("L'employé " + employe.getPrenom() + " " + employe.getNom() + " a été ajouter avec succès comme abonné !");
                    }

                }
            }
            if(!(resultat)){
                System.out.println("ce email ne correspond à aucun employé");
            }
        }
        else if (fichierJsonEmploye.exists() && fichierJsonEmploye.length() == 0) {
            System.out.println("Aucun n'employer n'existe veuillez creer un employé");
        } else {
            System.out.println("Le fichier employé n'existe pas !");
        }
    }
    //methode retirer un abonner
    public void retirerAbonner() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        File fichierJsonAbonnes = new File("lesAbonnes.json");
        // je veirfi si le fichier existe
        if(fichierJsonAbonnes.exists() && fichierJsonAbonnes.length() > 0){
            ListeAbonnes listesAbonnes = mapper.readValue(fichierJsonAbonnes,ListeAbonnes.class);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrer l'email de la personne à être retirer : ");
            String email = scanner.nextLine();
            boolean resultat = false;
            Abonne abonne1 = new Abonne() ;
            for(Abonne abonne : listesAbonnes.getAbonnes()){
                // je verifi si l'email existe
                if(abonne.getEmail().equals(email)){
                    resultat = true;
                    System.out.println("L'abonné " + abonne.getPrenom() + " " + abonne.getNom() + " a été retirer avec succès !");
                    abonne1 = abonne;
                    break;
                }
            }
            if(resultat){
                listesAbonnes.getAbonnes().remove(abonne1);
                mapper.writerWithDefaultPrettyPrinter().writeValue(fichierJsonAbonnes,listesAbonnes);
            }

            // cas ou l'email n'existe !
            if(!resultat){
                System.out.println("Aucun abonné ne correspond à cette addresse email !");
            }
        }
        else {
            System.out.println("Le fichier Json n'existe pas ");
        }


    }
    // methode afficher ListeDesAbonner
    public void afficherListeAbonner() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        File fichierJsonAbonnes = new File("lesAbonnes.json");
        if(fichierJsonAbonnes.exists() && fichierJsonAbonnes.length() > 0){
            ListeAbonnes listesAbonnes = mapper.readValue(fichierJsonAbonnes,ListeAbonnes.class);
            for(Abonne abonne : listesAbonnes.getAbonnes()){
                System.out.println("Prenom : " + abonne.getPrenom() + " Nom : " + abonne.getNom() + " Email : " + abonne.getEmail());
            }
        }
        else{
            System.out.println("Aucun employé n'est abonné à un service");
        }
    }
    // methode creer un employé
    public void creerUnEmploye() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        File fichierJsonEmploye = new File("lesEmployes.json");
        // Si le fichier existe et qu'il a des élements
        if(fichierJsonEmploye.exists() && fichierJsonEmploye.length() > 0){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrer votre prenom :");
            String prenom = scanner.nextLine();
            System.out.print("Entrer votre nom :");
            String nom = scanner.nextLine();
            System.out.print("Entrer votre email :");
            String email = scanner.nextLine();
            System.out.print("Entrer votre mot de passe :");
            String password = scanner.nextLine();
            Employe employe = new Employe(prenom,nom,email,password);
            ListeEmployes employes = mapper.readValue(fichierJsonEmploye, ListeEmployes.class);
            employes.getLesEmployes().add(employe);
            mapper.writerWithDefaultPrettyPrinter().writeValue(fichierJsonEmploye,employes);
            System.out.println("L'employé a été creer avec succès ");
        }
        // si le fichier existe mais n'a pas d'élément
        else if(fichierJsonEmploye.exists() && fichierJsonEmploye.length() == 0){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrer votre prenom :");
            String prenom = scanner.nextLine();
            System.out.print("Entrer votre nom :");
            String nom = scanner.nextLine();
            System.out.print("Entrer votre eamil :");
            String email = scanner.nextLine();
            System.out.print("Entrer votre mot de passe :");
            String password = scanner.nextLine();
            Employe employe = new Employe(prenom,nom,email,password);
           // ListeEmployes employes = mapper.readValue(fichierJsonEmploye, ListeEmployes.class);
            ListeEmployes employes = new ListeEmployes();
            employes.getLesEmployes().add(employe);
            mapper.writerWithDefaultPrettyPrinter().writeValue(fichierJsonEmploye,employes);
            System.out.println("L'employé a été creer avec succès !");
        }
        // si le fichier n'existe pas
        else {
            System.out.println("Le fichier Json n'existe pas contactez le developpeur !");
        }

    }
}

package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.listeDesModels.ListeAbonnes;
import org.example.model.Abonne;
import org.example.model.Admin;
import org.example.model.Employe;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        int choixUser=0;
        do{
            try{

                Scanner scanner = new Scanner(System.in);
                System.out.println("            B I E N V E N U            ");
                System.out.println("=======================================");
                System.out.println("voulez vous vous connecter en tant que ? ");
                System.out.println("                                       ");
                System.out.println("1.ADMIN       2.ABONNE     3.EMPLOYE      4.Quitter");
                System.out.print("votre choix :  ");
                choixUser = scanner.nextInt();
                if(choixUser == 1){
                    Scanner scaner1 = new Scanner(System.in);
                    Admin admin = new Admin("admin@gmail.com", "admin");
                    System.out.println("Entrer votre email : ");
                    String emailAdmin = scaner1.nextLine();
                    System.out.println("Entrer votre mot de passe : ");
                    String passwordAdmin = scaner1.nextLine();
                    int choixAdmin=0;

                        if(admin.getEmail().equals(emailAdmin) && admin.getPassword().equals(passwordAdmin)){
                            do{
                                System.out.println("            B I E N V E N U  A D M I N           ");
                                System.out.println("=================================================");
                                System.out.println("Que voulez vous faire ? ");
                                System.out.println("                                       ");
                                System.out.println("1.Ajouter Un Employé \n2.Ajouter un abonné  \n3.Retirer un abonné \n4.Afficher la liste des abonnés \n5.S'abonner à un service de Notification \n6. Se desabonner d'un service de Notification \n7. Affciher ses notifications reçues \n8.Envoyer un message \n9.Se Deconnecter");
                                System.out.print("votre choix :  ");
                                Scanner scanner2 = new Scanner(System.in);
                                choixAdmin = scanner2.nextInt();
                                if (choixAdmin == 1){
                                // Ajouter un employe
                                    admin.creerUnEmploye();
                                }
                                else if (choixAdmin ==2) {
                                // ajouter un abonner
                                    admin.ajouterAbonner();
                                }
                                else if (choixAdmin ==3) {
                                // retirer un abonné
                                    admin.retirerAbonner();
                                }
                                else if (choixAdmin ==4) {
                                // afficher la liste des abonnés
                                    admin.afficherListeAbonner();
                                }
                                else if (choixAdmin == 5) {

                                // s'abonner à un service de notification
                                }
                                else if (choixAdmin ==6) {
                                // Se desabonner d'un service de notification
                                }
                                else if (choixAdmin ==7) {
                                // afficher ses notifications reçues
                                }
                                else if (choixAdmin == 8) {
                                    // envoyer les messages
                                } else if (choixAdmin ==9) {
                                // se deconnecter
                                System.out.println("Deconnexion reussi Admin !");
                                }
                                else {
                                System.out.println("Votre choix est indisponible");
                                }
                            }while (choixAdmin !=9);
                        }
                        else{
                            System.out.println("Email ou mot de passe incorrect !");
                        }

                }
                // Se connecter comme un Abonne
                else if (choixUser ==2) {
                    ObjectMapper mapper = new ObjectMapper();
                    File fichier = new File("lesAbonnes.json");
                    System.out.println("Entrer votre email : ");
                    String emails = scanner.nextLine();
                    System.out.println("Entrer votre mot de passe :");
                    String passes = scanner.nextLine();
                    ListeAbonnes listesAbonnes = mapper.readValue(fichier, ListeAbonnes.class);
                    if(fichier.exists() && fichier.length() > 0){
                        int choixAbonne = 0;
                        do{
                        boolean resultat = false;
                        for(Abonne abonne : listesAbonnes.getAbonnes()){
                            if(abonne.getEmail().equals(emails) && abonne.getPassword().equals(passes)) {

                                resultat = true;
                                System.out.println("            B I E N V E N U  L'A B O N N E          ");
                                System.out.println("===================================================");
                                System.out.println("Que voulez vous faire ? ");
                                System.out.println("                                       ");
                                System.out.println("\n1.Se desabonner d'un Service de notification \n2.Afficher sa liste de notification \n3.Envoyer un message  \n3.Se deconnecter");
                                System.out.print("votre choix :  ");
                                Scanner scanner3 = new Scanner(System.in);
                                choixAbonne = scanner3.nextInt();
                                if (choixAbonne == 1) {
                                    // se desabonner d'un service de notification
                                    abonne.desabonnerServiceNotification();

                                } else if (choixAbonne == 2) {
                                    // afficher la liste des notifications
                                    abonne.afficherNotificationRecus();
                                } else if (choixAbonne == 3) {
                                    String objet="";
                                    String contenu="";
                                    abonne.envoyerNotification(objet,contenu);
                                    // envoyer un Message
                                } else if (choixAbonne == 4) {
                                    //Deconnexion
                                    System.out.println("Deconnexion reussi avec succès !");
                                }

                            }
                        }
                        if (!resultat){
                            System.out.println("Email ou mot de passe incorrect !");
                        }
                        }while (choixAbonne!=4);
                    }
                    else {
                        System.out.println("Le fichier n'existe pas");
                    }
                }
                else if (choixUser ==3) {
                    System.out.println("Deconnexion reussi !");
                }
                else {
                    System.out.println("Choix non disponible");
                }

            }catch (InputMismatchException e){
                System.out.println("Choix non dispobile");
            }
        }while (choixUser !=4);
    }
}
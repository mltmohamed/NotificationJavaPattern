package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int choixUser=0;
        do{
            try{

                Scanner scanner = new Scanner(System.in);
                System.out.println("            B I E N V E N U            ");
                System.out.println("=======================================");
                System.out.println("voulez vous vous connecter en tant que ? ");
                System.out.println("                                       ");
                System.out.println("1.ADMIN       2.UTILISATEUR      3.Quitter");
                System.out.print("votre choix ? ");
                choixUser = scanner.nextInt();
                if(choixUser == 1){
                    System.out.println("Bonjour admin");
                }
                else if (choixUser ==2) {
                    System.out.println("Bonjour Utilisateur");
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
        }while (choixUser !=3);
    }
}
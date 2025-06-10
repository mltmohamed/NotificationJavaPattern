package org.example.model;

import org.example.service.AdminService;

public class Admin extends AdminService {
    String email;
    String password;

    // les getters email password
    public String getEmail() {return email;}
    public String getPassword() {return password;}

    //les setters email password
    public void setPassword(String password) {this.password = password;}
    public void setEmail(String email) {this.email = email;}

    // methode s'abonner à un service de notification
    public void abonnerServiceNotification(){

    }
    // methode se desabonner d'un service de notification
    public void desabonnerServiceNotification(){

    }
    // methode afficher notificationRecus
    public void afficherNotificationRecus(){

    }
}

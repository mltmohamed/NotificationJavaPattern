package org.example.listeDesModels;

import org.example.model.Notification;

import java.util.ArrayList;
import java.util.List;

public class ListeNotification {

    List<Notification> listeNotification= new ArrayList<>();
    public ListeNotification(List<Notification> listeNotification)
        {this.listeNotification = listeNotification;}
    public ListeNotification(){}

    public List<Notification> getListeNotification() {return listeNotification;}

    public void setListeNotification(List<Notification> listeNotification)
            {this.listeNotification = listeNotification;}
}

package org.example.Interface;

import java.io.IOException;

public interface Message {
    public void envoyerNotification(String objet, String contenu) throws IOException;
    public void envoyerEmail(String objet, String contenu) throws IOException;
}

package fr.uvsq.cprog.collex;

import java.util.Scanner;

public class DnsTUI {

    private Scanner scanner;

  
    public DnsTUI() {
        scanner = new Scanner(System.in);
    }

  
    public String nextCommande() {
        System.out.print("> ");
        return scanner.nextLine();
    }

    
    public void affiche(String message) {
        System.out.println(message);
    }

  //on ferme le scanner a la fin du programme
    public void close() {
        scanner.close();
    }
}

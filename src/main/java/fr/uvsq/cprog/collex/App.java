package fr.uvsq.cprog.collex;

public class App {
    public static void main(String[] args) {
        AdresseIP ip1 = new AdresseIP("193.51.31.90");
        System.out.println("Adresse valide : " + ip1);

        try {
            AdresseIP ip2 = new AdresseIP("999.1.1.1"); // invalide
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur détectée : " + e.getMessage());
        }
    }
}

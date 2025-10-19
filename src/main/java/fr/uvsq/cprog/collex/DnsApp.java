package fr.uvsq.cprog.collex;

import fr.uvsq.cprog.collex.commande.*;

import java.io.IOException;
import java.util.List;

public class DnsApp {

    private Dns dns;
    private DnsTUI tui;

    public DnsApp(String fichier) throws IOException {
        dns = new Dns(fichier);
        tui = new DnsTUI();
    }

    public void run() {
        while (true) {
            String ligne = tui.nextCommande().trim();
            Commande cmd = parseCommande(ligne);
            if (cmd != null) {
                cmd.execute();
            }
        }
    }

    private Commande parseCommande(String ligne) {
        if (ligne.equalsIgnoreCase("quit")) {
            return new QuitterCommande(tui);
        } else if (ligne.startsWith("add ")) {
            // format : add ip nomMachine
            String[] parts = ligne.split(" ");
            if (parts.length == 3) {
                return new AddCommande(dns, tui, parts[1], parts[2]);
            } else {
                tui.affiche("ERREUR : Syntaxe incorrecte pour add !");
                return null;
            }
        } else if (ligne.matches("([0-9]{1,3}\\.){3}[0-9]{1,3}")) {
            return new RechercheNomCommande(dns, tui, ligne);
        } else if (ligne.contains(".")) {
            return new RechercheIPCommande(dns, tui, ligne);
        } else {
            tui.affiche("ERREUR : Commande inconnue !");
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            String fichier = "dns.txt"; // nom du fichier de base
            new DnsApp(fichier).run();
        } catch (IOException e) {
            System.out.println("ERREUR : Impossible de charger le fichier DNS !");
        }
    }
}

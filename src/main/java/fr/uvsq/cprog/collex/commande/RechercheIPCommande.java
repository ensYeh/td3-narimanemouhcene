package fr.uvsq.cprog.collex.commande;

import fr.uvsq.cprog.collex.*;

public class RechercheIPCommande implements Commande {

    private Dns dns;
    private DnsTUI tui;
    private String nomMachine;

    public RechercheIPCommande(Dns dns, DnsTUI tui, String nomMachine) {
        this.dns = dns;
        this.tui = tui;
        this.nomMachine = nomMachine;
    }

    @Override
    public void execute() {
        try {
            // Convertir la String en NomMachine
            NomMachine nom = new NomMachine(nomMachine);

            // Récupérer l'entrée DNS
            DnsItem item = dns.getItem(nom);

            // Afficher l'adresse IP
            tui.affiche(item.getIp().toString()); // ← ici getIp()
        } catch (Exception e) {
            tui.affiche("ERREUR : Machine non trouvée !");
        }
    }
}

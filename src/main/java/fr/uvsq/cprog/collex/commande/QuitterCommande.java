package fr.uvsq.cprog.collex.commande;

import fr.uvsq.cprog.collex.Commande;
import fr.uvsq.cprog.collex.DnsTUI;

/**
 * Commande pour quitter l'application DNS.
 * Affiche un message et termine le programme proprement.
 */
public class QuitterCommande implements Commande {

    private DnsTUI tui;

    /**
     * Constructeur : on donne l'interface utilisateur pour afficher le message
     * @param tui l'interface texte
     */
    public QuitterCommande(DnsTUI tui) {
        this.tui = tui;
    }

   
    @Override
    public void execute() {
        tui.affiche("Au revoir !");
        tui.close(); // ferme le scanner proprement
        System.exit(0); // termine le programme
    }
}

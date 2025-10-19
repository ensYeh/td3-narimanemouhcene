package fr.uvsq.cprog.collex.commande;

import fr.uvsq.cprog.collex.*;

import java.io.IOException;

public class AddCommande implements Commande {

    private Dns dns;
    private DnsTUI tui;
    private String ipStr;
    private String nomMachineStr;

    public AddCommande(Dns dns, DnsTUI tui, String ipStr, String nomMachineStr) {
        this.dns = dns;
        this.tui = tui;
        this.ipStr = ipStr;
        this.nomMachineStr = nomMachineStr;
    }

    @Override
    public void execute() {
        try {
            AdresseIP ip = new AdresseIP(ipStr);
            NomMachine nom = new NomMachine(nomMachineStr);
            dns.addItem(ip, nom);
            tui.affiche("Machine ajoutée avec succès !");
        } catch (IllegalArgumentException e) {
            tui.affiche("ERREUR : " + e.getMessage());
        } catch (IOException e) {
            tui.affiche("ERREUR : Impossible de mettre à jour le fichier !");
        }
    }
}

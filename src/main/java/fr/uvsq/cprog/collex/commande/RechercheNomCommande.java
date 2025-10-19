package fr.uvsq.cprog.collex.commande;

import fr.uvsq.cprog.collex.AdresseIP;
import fr.uvsq.cprog.collex.Commande;
import fr.uvsq.cprog.collex.Dns;
import fr.uvsq.cprog.collex.DnsItem;
import fr.uvsq.cprog.collex.DnsTUI;

public class RechercheNomCommande implements Commande {

    private Dns dns;
    private DnsTUI tui;
    private String adresseIP;

    public RechercheNomCommande(Dns dns, DnsTUI tui, String adresseIP) {
        this.dns = dns;
        this.tui = tui;
        this.adresseIP = adresseIP;
    }

    @Override
    public void execute() {
        try {
            // Convertir la String en AdresseIP
            AdresseIP ip = new AdresseIP(adresseIP);

            // Récupérer l'entrée DNS
            DnsItem item = dns.getItem(ip);

            // Afficher le nom de la machine
            tui.affiche(item.getNom().toString());
        } catch (Exception e) {
            tui.affiche("ERREUR : Adresse IP non trouvée !");
        }
    }
}

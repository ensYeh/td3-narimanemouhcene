package fr.uvsq.cprog.collex.commande;

import fr.uvsq.cprog.collex.DnsItem;
import fr.uvsq.cprog.collex.DnsService;
import fr.uvsq.cprog.collex.Commande;

import java.util.List;

/**
 * Commande permettant d’afficher la liste des domaines triés par nom.
 */
public class ListeDomaineCommande implements Commande {

    private final DnsService serviceDns;

    public ListeDomaineCommande(DnsService serviceDns) {
        this.serviceDns = serviceDns;
    }

    @Override
    public void execute() {
        // Récupération de la liste des domaines triés par nom
        List<DnsItem> domaines = serviceDns.listeTrieeParNom();

        // Affichage
        domaines.forEach(System.out::println);
    }
}

package fr.uvsq.cprog.collex.commande;

import fr.uvsq.cprog.collex.*;

import java.util.Comparator;
import java.util.List;

public class ListeDomaineParIpCommande implements Commande {

    private Dns dns;
    private DnsTUI tui;
    private String domaine;

    public ListeDomaineParIpCommande(Dns dns, DnsTUI tui, String domaine) {
        this.dns = dns;
        this.tui = tui;
        this.domaine = domaine;
    }

    @Override
    public void execute() {
        List<DnsItem> items = dns.getItems(domaine);
        items.sort(Comparator.comparing(DnsItem::getIp));
        for (DnsItem item : items) {
            tui.affiche(item.toString());
        }
    }
}

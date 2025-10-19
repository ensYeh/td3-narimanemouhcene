package fr.uvsq.cprog.collex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DnsService {
    private List<DnsItem> items = new ArrayList<>();

    public void ajouterItem(DnsItem item) {
        items.add(item);
    }

    public Optional<AdresseIP> rechercheIP(NomMachine nom) {
        return items.stream()
                .filter(i -> i.getNom().equals(nom))
                .map(DnsItem::getIp)
                .findFirst();
    }

    public Optional<NomMachine> rechercheNom(AdresseIP ip) {
        return items.stream()
                .filter(i -> i.getIp().equals(ip))
                .map(DnsItem::getNom)
                .findFirst();
    }

    public List<DnsItem> liste() {
        return new ArrayList<>(items);
    }

    public List<DnsItem> listeTrieeParNom() {
        return items.stream()
                .sorted(Comparator.comparing(i -> i.getNom().toString()))
                .collect(Collectors.toList());
    }
}

package fr.uvsq.cprog.collex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dns {

    private List<DnsItem> items; // contient toutes les entrées du DNS
    private Path fichier;         // chemin du fichier de la base

    /**
     * Constructeur : charge la base depuis un fichier
     * @param nomFichier le nom du fichier de base
     * @throws IOException si le fichier ne peut être lu
     */
    public Dns(String nomFichier) throws IOException {
        this.items = new ArrayList<>();
        this.fichier = Paths.get(nomFichier);
        charger();
    }

    /** Charge les items depuis le fichier texte */
    private void charger() throws IOException {
        if (!Files.exists(fichier)) return;

        List<String> lignes = Files.readAllLines(fichier);
        for (String ligne : lignes) {
            String[] parts = ligne.split(" ");
            if (parts.length == 2) {
                NomMachine nom = new NomMachine(parts[0]);
                AdresseIP ip = new AdresseIP(parts[1]);
                items.add(new DnsItem(ip, nom));
            }
        }
    }

    /** Retourne l'item correspondant à l'adresse IP ou null si non trouvé */
    public DnsItem getItem(AdresseIP ip) {
        for (DnsItem item : items) {
            if (item.getIp().equals(ip)) return item;
        }
        return null;
    }

    /** Retourne l'item correspondant au nom de machine ou null si non trouvé */
    public DnsItem getItem(NomMachine nom) {
        for (DnsItem item : items) {
            if (item.getNom().equals(nom)) return item;
        }
        return null;
    }

    /** Retourne la liste des items correspondant à un domaine */
    public List<DnsItem> getItems(String domaine) {
        List<DnsItem> resultat = new ArrayList<>();
        for (DnsItem item : items) {
            if (item.getNom().getValeur().endsWith("." + domaine)) {
                resultat.add(item);
            }
        }
        return resultat;
    }

    /**
     * Ajoute un nouvel item dans le DNS et met à jour le fichier
     * @param ip l'adresse IP
     * @param nom le nom de machine
     * @throws IOException si le fichier ne peut être écrit
     * @throws IllegalArgumentException si l'IP ou le nom existe déjà
     */
    public void addItem(AdresseIP ip, NomMachine nom) throws IOException {
        if (getItem(ip) != null)
            throw new IllegalArgumentException("Erreur : L'adresse IP existe déjà !");
        if (getItem(nom) != null)
            throw new IllegalArgumentException("Erreur : Le nom de machine existe déjà !");

        DnsItem item = new DnsItem(ip, nom);
        items.add(item);

        // mise à jour du fichier
        Files.write(fichier,
                Arrays.asList(nom.getValeur() + " " + ip.getValeur()),
                StandardOpenOption.APPEND,
                StandardOpenOption.CREATE);
    }
}

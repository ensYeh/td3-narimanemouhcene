package fr.uvsq.cprog.collex;
public class DnsItem {
    private AdresseIP ip;
    private NomMachine nom;

    public DnsItem(AdresseIP ip, NomMachine nom) {
        this.ip = ip;
        this.nom = nom;
    }

    public AdresseIP getIp() {
        return ip;
    }

    public NomMachine getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return ip + " " + nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DnsItem)) return false;
        DnsItem autre = (DnsItem) o;
        return ip.equals(autre.ip) && nom.equals(autre.nom);
    }

    @Override
    public int hashCode() {
        return ip.hashCode() * 31 + nom.hashCode();
    }
}

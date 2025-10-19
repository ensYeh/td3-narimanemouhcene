public class NomMachine {
    private String valeur; // le nom complet de la machine

    public NomMachine(String nom) {
        if (!valide(nom)) {
            throw new IllegalArgumentException("Nom de machine invalide : " + nom);
        }
        this.valeur = nom;
    }
    private boolean valide(String nom) {
    if (nom == null || nom.isEmpty()) return false;
    // Vérifie qu'il y a au moins un point séparant le nom de la machine et le domaine
    return nom.contains(".");
}
public String getValeur() {
    return valeur;
}

@Override
public String toString() {
    return valeur;
}
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof NomMachine)) return false;
    NomMachine autre = (NomMachine) o;
    return this.valeur.equals(autre.valeur);
}

@Override
public int hashCode() {
    return valeur.hashCode();
}
}

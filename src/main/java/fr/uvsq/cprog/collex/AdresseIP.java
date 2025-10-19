package fr.uvsq.cprog.collex;


public class AdresseIP implements Comparable<AdresseIP> {
    private final String valeur; //pour stocker l'adresse ip

   
    public AdresseIP(String valeur) {
        if (!isValid(valeur)) {
            throw new IllegalArgumentException("Adresse IP invalide : " + valeur);
        }
        this.valeur = valeur;
    }

    //methode pour verifier la validité de notre adresse ip 
    public static boolean isValid(String ip) {
        if (ip == null || ip.isEmpty()) return false;
        String[] parties = ip.split("\\.");
        if (parties.length != 4) return false;

        for (String p : parties) {
            try {
                int nombre = Integer.parseInt(p);
                if (nombre < 0 || nombre > 255) return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    /* retourner la valeur de ladresse ip */
    public String getValeur() {
        return valeur;
    }

    /** Affichage lisible. */
    @Override
    public String toString() {
        return valeur;
    }

    /* Pour comparer deux adresses IP  */
    @Override
    public int compareTo(AdresseIP autre) {
        String[] a = this.valeur.split("\\.");
        String[] b = autre.valeur.split("\\.");
        for (int i = 0; i < 4; i++) {
            int diff = Integer.parseInt(a[i]) - Integer.parseInt(b[i]);
            if (diff != 0) return diff;
        }
        return 0;
    }

    /** check si les deux adresse ip sont egale  */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdresseIP)) return false;
        AdresseIP autre = (AdresseIP) o;
        return this.valeur.equals(autre.valeur);
    }

    /** Nécessaire pour stocker dans les collections (HashMap, Set, etc.). */
    @Override
    public int hashCode() {
        return valeur.hashCode();
    }
}

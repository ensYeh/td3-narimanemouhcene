package fr.uvsq.cprog.collex;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DnsTest {

    @Test
    public void testAdresseIPValide() {
        assertTrue(AdresseIP.isValid("192.168.0.1"));
        assertFalse(AdresseIP.isValid("999.0.0.1"));
        assertFalse(AdresseIP.isValid("abc.def.ghi.jkl"));
    }

    @Test
    public void testNomMachineValide() {
        NomMachine nom = new NomMachine("www.uvsq.fr");
        assertEquals("www.uvsq.fr", nom.getValeur());
    }

    @Test
    public void testAjoutEtRechercheDns() throws IOException {
        Path tempFile = Files.createTempFile("dns", ".txt");
        Dns dns = new Dns(tempFile.toString());

        AdresseIP ip = new AdresseIP("193.51.31.90");
        NomMachine nom = new NomMachine("www.uvsq.fr");

        dns.addItem(ip, nom);

        assertEquals(ip, dns.getItem(nom).getIp());
        assertEquals(nom, dns.getItem(ip).getNom());
    }
}

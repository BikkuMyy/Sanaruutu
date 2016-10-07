package sanapeli.logiikka;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Luokka tarkistaa, sisältyykö sille annettu sana sen attribuuttina olevaan
 * sanalistaan.
 *
 */
public class SananTarkistaja {

    private HashSet<String> sanat;
    private File tiedosto;

    /**
     * Konstruktori.
     * @param tiedostonNimi luettavan tiedoston nimi
     */
    public SananTarkistaja(String tiedostonNimi) {
        this.sanat = new HashSet();
        this.tiedosto = new File(tiedostonNimi);
        lueTiedostoHashSetiin();
    }
    
    /**
     * Metodi tarkistaa onko sille parametrina annettu sana sanalistalla.
     * 
     * @param sana  tarkistettava sana
     * 
     * @return true/false
     */
    public boolean tarkistaSana(String sana) {
        if (this.sanat.contains(sana.toLowerCase())) {
            return true;
        }
        return false;
    }

    private void lueTiedostoHashSetiin() {
        Scanner lukija = null;

        try {
            lukija = new Scanner(tiedosto, "UTF-8");
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
            return;
        }

        while (lukija.hasNextLine()) {
            this.sanat.add(lukija.nextLine().split("-")[1]);
        }

        lukija.close();

    }

    public HashSet<String> getSanat() {
        return sanat;
    }
}

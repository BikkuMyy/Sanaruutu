package sanapeli.logiikka;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Luokka tarkistaa, sisältyykö sille annettu sana sen attribuuttina olevaan
 * sanalistaan.
 *
 */
public class SananTarkistaja {

    private HashSet<String> sanat;
    private InputStream tiedosto;

    /**
     * Konstruktori.
     *
     * @param tiedostonNimi luettavan tiedoston nimi
     */
    public SananTarkistaja(String tiedostonNimi) {
        this.sanat = new HashSet();
        this.tiedosto = getClass().getResourceAsStream(tiedostonNimi);
        lueTiedostoHashSetiin();
    }

    /**
     * Metodi tarkistaa onko sille parametrina annettu sana sanalistalla tai
     * tarkistaa onko sana pidempi kuin yksi merkki jos lista on tyhjä.
     *
     * @param sana tarkistettava sana
     *
     * @return true/false
     */
    public boolean tarkistaSana(String sana) {
        if (this.sanat.contains(sana.toLowerCase())) {
            return true;
        } else if (sana.length() > 1 && this.sanat.isEmpty()) {
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
            this.sanat.add(lukija.nextLine());
        }

        lukija.close();

    }

    public HashSet<String> getSanat() {
        return sanat;
    }
}

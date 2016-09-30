
package sanapeli.logiikka;

import javax.swing.SwingUtilities;
import sanapeli.kayttoliittyma.Kayttoliittyma;

/**
 * Luokka vastaa Pelialustan ja Kayttoliittyman luomisesta sekä pelin käynnistämisestä.
 */


public class Sanapeli {
    private Pelialusta pelialusta;

    public Sanapeli() {
        this.pelialusta = new Pelialusta();
    }
    
    /**
     * Metodi luo ohjelman käyttöliittymän ja pelialustan alkutilanteen. 
     */
    
    public void kaynnista() {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(pelialusta);
        SwingUtilities.invokeLater(kayttoliittyma);
        pelialusta.luoAlkuTilanne();
        
    }
}

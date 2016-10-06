
package sanapeli.logiikka;

import java.util.ArrayList;
import javax.swing.SwingUtilities;
import sanapeli.kayttoliittyma.Kayttoliittyma;

/**
 * Luokka vastaa Pelialustan ja Kayttoliittyman luomisesta sekä pelin käynnistämisestä.
 */

//pitäiskö tämän toteuttaa rajapinta ja vastata kaikesta liikenteestä
//Pelialusta-luokka ei siihen sovi!
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

//    @Override
//    public Ruutu[][] getRuudukko() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Ruutu getRuutu(int y, int x) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public ArrayList<Ruutu> getValitut() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean tarkistaSana(String sana) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void paivitaRuudukko() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}


package sanapeli.logiikka;

import java.util.ArrayList;

/**
 * Rajapinta sovelluslogiikan ja kayttöliittymän välillä.
 * 
 */

public interface Peliruudukko {
    
    Ruutu [][] getRuudukko();
    
    Ruutu getRuutu(int y, int x);
    
    ArrayList<Ruutu> getValitut();
    
    boolean tarkistaSana(String sana);
    
    void paivitaRuudukko();

    public void lopeta();
}

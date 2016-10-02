
package sanapeli.logiikka;

import java.util.ArrayList;

/**
 * Rajapinta sovelluslogiikan ja kayttöliittymän välillä.
 * @author mari
 */

public interface Peliruudukko {
    
    Ruutu [][] getRuudukko();
    
    Ruutu getRuutu(int y, int x);
    
    ArrayList<Ruutu> getValitut();
    
    void paivitaRuudukko();

}

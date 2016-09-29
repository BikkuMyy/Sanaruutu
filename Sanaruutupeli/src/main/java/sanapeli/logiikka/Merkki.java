
package sanapeli.logiikka;

import java.io.FileNotFoundException;

/**
 * Luokka tallentaa tiedon ruudun sisältämästä merkistä.
 *
 * @author mari
 */

public class Merkki extends Sisalto {
    private String merkki;
//    private int pisteet;

    public Merkki() throws FileNotFoundException {
        this.merkki = super.randomizer.satunnainenMerkki();
    }

//    public int getPisteet() {
//        return pisteet;
//    }

    @Override
    public String toString() {
        return this.merkki;
    }
    
    
    
}

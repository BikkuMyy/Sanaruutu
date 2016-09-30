
package sanapeli.logiikka;

/**
 * Luokka tallentaa tiedon ruudun sisältämästä merkistä.
 *
 * @author mari
 */

public class Merkki extends Sisalto {
    private String merkki;
//    private int pisteet;

    public Merkki() {
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

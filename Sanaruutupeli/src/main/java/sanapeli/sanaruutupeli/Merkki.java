
package sanapeli.sanaruutupeli;

import java.io.FileNotFoundException;


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
    public String getSisalto() {
        return merkki;
    }

    @Override
    public String toString() {
        return this.merkki;
    }
    
    
    
}

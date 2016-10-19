package sanapeli.logiikka;

/**
 * Luokka tallentaa tiedon ruudun sisältämästä merkistä.
 *
 * @author mari
 */
public class Merkki extends Sisalto {

    private String merkki;
    private int pisteet;

    /**
     * Konstruktori.
     */
    public Merkki() {
        this.merkki = super.satunnainen.satunnainenMerkki();
        asetaPisteet();
    }

    @Override
    public int getPisteet() {
        return this.pisteet;
    }

    @Override
    public String toString() {
        return this.merkki;
    }

    private void asetaPisteet() {
        this.pisteet = 4;
        
        if ("AEINST".contains(merkki)) {
            this.pisteet = 1;
        }
        if ("UOÄKLM".contains(merkki)) {
            this.pisteet = 2;
        }
        if ("PRHJYV".contains(merkki)) {
            this.pisteet = 3;
        }

    }

}

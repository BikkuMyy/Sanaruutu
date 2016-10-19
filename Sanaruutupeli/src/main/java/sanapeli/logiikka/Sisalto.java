
package sanapeli.logiikka;

/**
 * Abstrakti luokka, joka määrittelee alaluokkiensa pakolliset toiminnot.
 * 
 */

public abstract class Sisalto {
    
    public Satunnaistaja satunnainen;
    
    /**
     * Konstruktori.
     */
    public Sisalto() {
        this.satunnainen = new Satunnaistaja("kirjaimet.txt");
    }
    
    /**
     * Metodi palauttaa sisältöön liittyvän pistemäärän.
     * @return pisteet
     */
    public abstract int getPisteet();

    @Override
    public abstract String toString();
    
    
}

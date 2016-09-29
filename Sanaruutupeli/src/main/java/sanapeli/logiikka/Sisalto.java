
package sanapeli.logiikka;

import java.io.FileNotFoundException;

/**
 * Abstrakti luokka, joka määrittelee alaluokkiensa pakolliset toiminnot.
 * @author mari
 */

public abstract class Sisalto {
    
    public Randomizer randomizer;

    public Sisalto() throws FileNotFoundException {
        this.randomizer = new Randomizer("kirjaimet.txt");
    }
    
    // public abstract int getPisteet();

    @Override
    public abstract String toString();
    
    
}


package sanapeli.logiikka;

import java.io.FileNotFoundException;

public abstract class Sisalto {
    
    public Randomizer randomizer;

    public Sisalto() throws FileNotFoundException {
        this.randomizer = new Randomizer("kirjaimet.txt");
    }
    
    public abstract String getSisalto();
    
    // public abstract int getPisteet();

    @Override
    public abstract String toString();
    
    
}

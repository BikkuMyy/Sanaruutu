
package sanapeli.sanaruutupeli;

import java.io.FileNotFoundException;


public class Kirjain extends Sisalto {
    private String kirjain;
    private Randomizer randomizer;
    //randomizer pitäs saaha jonnekki muualle ettei jokainen kirjain lois sitä uudestaan
    //private int pisteet;

    public Kirjain() throws FileNotFoundException {
        this.randomizer = new Randomizer("kirjaimet.txt");
        this.kirjain = randomizer.satunnainenMerkki();
    }

//    public int getPisteet() {
//        return pisteet;
//    }

    @Override
    public String getSisalto() {
        return kirjain;
    }

    @Override
    public String toString() {
        return this.kirjain;
    }
    
    
    
}

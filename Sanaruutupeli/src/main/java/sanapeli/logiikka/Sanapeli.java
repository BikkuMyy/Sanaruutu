
package sanapeli.logiikka;

import java.io.FileNotFoundException;
import javax.swing.SwingUtilities;
import sanapeli.kayttoliittyma.Kayttoliittyma;


public class Sanapeli {
    private Pelialusta pelialusta;

    public Sanapeli() {
        this.pelialusta = new Pelialusta();
    }
    
    public void kaynnista() throws FileNotFoundException {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(pelialusta);
        SwingUtilities.invokeLater(kayttoliittyma);
        pelialusta.luoAlkuTilanne();
//        pelialusta.tulostaTilanne();
        
    }
}

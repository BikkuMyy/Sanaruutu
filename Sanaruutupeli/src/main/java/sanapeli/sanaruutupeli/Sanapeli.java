
package sanapeli.sanaruutupeli;

import java.io.FileNotFoundException;


public class Sanapeli {
    private Pelialusta pelialusta;

    public Sanapeli() {
        this.pelialusta = new Pelialusta();
    }
    
    public void kaynnista() throws FileNotFoundException {
        
        pelialusta.luoAlkuTilanne();
        pelialusta.tulostaTilanne();
        //looppi
    }
    
    
    
    
}

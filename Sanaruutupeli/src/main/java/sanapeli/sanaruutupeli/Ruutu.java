
package sanapeli.sanaruutupeli;

import java.io.FileNotFoundException;


public class Ruutu {
    private Sijainti sijainti;
    private Sisalto sisalto;

    public Ruutu(int y, int x) throws FileNotFoundException {
        this.sijainti = new Sijainti(y, x);
        this.sisalto = new Kirjain();
    }
    
    public void tyhjennaRuudunSisalto(){
        this.sisalto = null;
    }

    public Sijainti getSijainti() {
        return this.sijainti;
    }

    public Sisalto getSisalto() {
        return this.sisalto;
    }
    

    @Override
    public String toString() {
        return this.sisalto.toString();
    }
    
    
    
    
}

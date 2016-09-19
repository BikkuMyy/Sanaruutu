package sanapeli.logiikka;

import java.io.FileNotFoundException;

public class Ruutu {

    private Sijainti sijainti;
    private Sisalto sisalto;

    public Ruutu(int y, int x) {
        this.sijainti = new Sijainti(y, x);
        this.sisalto = null;
    }
    
    public void lisaaRuutuunSisalto() throws FileNotFoundException{
        this.sisalto = new Merkki();
    }

   
    public void tyhjennaRuudunSisalto() {
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

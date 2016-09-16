package sanapeli.logiikka;

import java.io.FileNotFoundException;

public class Ruutu implements Sanaruutu {

    private Sijainti sijainti;
    private Sisalto sisalto;

    public Ruutu(int y, int x) throws FileNotFoundException {
        this.sijainti = new Sijainti(y, x);
        this.sisalto = new Merkki();
    }

    @Override
    public void tyhjennaRuudunSisalto() {
        this.sisalto = null;
    }

    @Override
    public Sijainti getSijainti() {
        return this.sijainti;
    }

    @Override
    public Sisalto getSisalto() {
        return this.sisalto;
    }

    @Override
    public String toString() {
        return this.sisalto.toString();
    }

}

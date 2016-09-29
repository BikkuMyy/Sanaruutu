package sanapeli.logiikka;

import java.io.FileNotFoundException;

/**
 * Luokka sisältää yhteen ruutuun liittyvät tiedot ja metodit niiden käsittelyyn.
 * @author mari
 */


public class Ruutu {

    private int y;
    private int x;
    private Sisalto sisalto;

    public Ruutu(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public void lisaaRuutuunSisalto() throws FileNotFoundException {
        this.sisalto = new Merkki();
    }

    public void tyhjennaRuudunSisalto() {
        this.sisalto = null;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Sisalto getSisalto() {
        return this.sisalto;
    }

    @Override
    public String toString() {
        if (this.sisalto == null) {
            return "";

        }
        return this.sisalto.toString();
    }

}

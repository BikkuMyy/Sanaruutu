package sanapeli.logiikka;

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
    
    /**
     * Metodi lisää uuden Merkki-olion sisalto-attribuuttiin.
     */
    public void lisaaRuutuunSisalto() {
        this.sisalto = new Merkki();
    }
    
    /**
     * Metodi muuttaa sisalto-atribuutin arvoksi null.
     */

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

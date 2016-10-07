package sanapeli.logiikka;

/**
 * Luokka sisältää yhteen ruutuun liittyvät tiedot ja metodit niiden käsittelyyn.
 * @author mari
 */
public class Ruutu {

    private int y;
    private int x;
    private Sisalto sisalto;

    /**
     * Konstruktori.
     * @param y ruudun y-koordinaatti
     * @param x ruudun x-koordinaatti
     */
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

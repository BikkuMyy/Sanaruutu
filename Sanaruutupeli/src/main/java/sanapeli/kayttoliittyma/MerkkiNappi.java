package sanapeli.kayttoliittyma;

import java.awt.Color;
import javax.swing.JButton;
import sanapeli.logiikka.Peliruudukko;

/**
 * Luokka sisältää yhteen nappiin liittyvät tiedot ja metodit niiden käsittelemiseen.
 * @author mari
 */

public class MerkkiNappi extends JButton {

    private Peliruudukko ruudukko;
    private String merkki;
    private  int y;
    private int x;

    public MerkkiNappi(int y, int x, Peliruudukko ruudukko) {
        this.ruudukko = ruudukko;
        this.y = y;
        this.x = x;
        setMerkki();
    }

    public String getMerkki() {
        return this.merkki;
    }

    public void setMerkki() {
        super.setText(this.merkki = haeNappiinMerkkiRuudusta());
    }

    private String haeNappiinMerkkiRuudusta() {
        return ruudukko.getRuudukko()[y][x].toString();
    }
    
    /**
     * Metodi palauttaa napin x-koordinaatin.
     * 
     * @return MerkkiNappi-olion x
     */
    public int haeX() {
        return this.x;
    }
    
    /**
     * Metodi palauttaa napin y-koordinaatin.
     * 
     * @return MerkkiNappi-olion y
     */
    public int haeY() {
        return this.y;
    }

    public Peliruudukko getRuudukko() {
        return ruudukko;
    }
    
    public void hyvaksy(){
        setText("");
        setBackground(Color.MAGENTA);
        setEnabled(false);
    }
    
    
    
    

}

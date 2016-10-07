package sanapeli.kayttoliittyma;

import java.awt.Color;
import javax.swing.JButton;
import sanapeli.logiikka.Peliruudukko;

/**
 * Luokka sisältää yhteen nappiin liittyvät tiedot ja metodit niiden
 * käsittelemiseen.
 *
 */
public class MerkkiNappi extends JButton {

    private Peliruudukko sanapeli;
    private String merkki;
    private int y;
    private int x;

    /**
     * Konstruktori.
     * @param y napin y-koordinaatti
     * @param x napin x-koordinaatti
     * @param sanapeli Peliruudukko-rajapinnan ilmentymä
     */
    public MerkkiNappi(int y, int x, Peliruudukko sanapeli) {
        this.sanapeli = sanapeli;
        this.y = y;
        this.x = x;
        super.setText(this.merkki = haeNappiinMerkkiRuudusta());
    }

    
    public String getMerkki() {
        return this.merkki;
    }

    /**
     * Metodi hakee merkki-muuttujaan sisällön napin koordinaatteja vastaavasta ruudusta
     * ja asettaa sen JButtonissa näkyväksi tekstiksi. 
     */
    public void setMerkki() {
        super.setText(this.merkki = haeNappiinMerkkiRuudusta());
    }

    private String haeNappiinMerkkiRuudusta() {
        return sanapeli.getRuudukko()[y][x].toString();
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
        return sanapeli;
    }
    /**
     * Metodi toteuttaa napissa tapahtuvat muutokset, 
     * kun hyväksy-nappia painetaan.
     * 
     */
    public void hyvaksy() {
        setText("");
        setBackground(Color.MAGENTA);
        setEnabled(false);
    }

}

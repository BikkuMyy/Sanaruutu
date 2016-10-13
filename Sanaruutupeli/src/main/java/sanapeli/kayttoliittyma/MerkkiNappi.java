package sanapeli.kayttoliittyma;

import java.awt.Color;
import javax.swing.JButton;
import sanapeli.logiikka.Pelilogiikka;

/**
 * Luokka sisältää yhteen nappiin liittyvät tiedot ja metodit niiden
 * käsittelemiseen.
 *
 */
public class MerkkiNappi extends JButton {

    private Pelilogiikka pelinhallinta;
    private String merkki;
    private int y;
    private int x;

    /**
     * Konstruktori.
     *
     * @param y napin y-koordinaatti
     * @param x napin x-koordinaatti
     * @param hallinta Peliruudukko-rajapinnan ilmentymä
     */
    public MerkkiNappi(int y, int x, Pelilogiikka hallinta) {
        this.pelinhallinta = hallinta;
        this.y = y;
        this.x = x;
        setMerkki();
    }

    /**
     * Metodi hakee merkki-muuttujaan sisällön napin koordinaatteja vastaavasta
     * ruudusta ja asettaa sen JButtonissa näkyväksi tekstiksi.
     */
    public void setMerkki() {
        super.setText(this.merkki = haeNappiinMerkkiRuudusta());
        tarkistaAktiivisuus();
    }

    private String haeNappiinMerkkiRuudusta() {
        return pelinhallinta.getRuudukko()[y][x].toString();
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

    public Pelilogiikka getRuudukko() {
        return pelinhallinta;
    }

    /**
     * Metodi toteuttaa napissa tapahtuvat muutokset, kun hyväksy-nappia
     * painetaan.
     *
     */
    public void hyvaksy() {
        setText("");
        setBackground(Color.MAGENTA);
        setEnabled(false);
    }

    private void tarkistaAktiivisuus() {
        if (this.merkki.isEmpty()) {
            setEnabled(false);
        } else {
            setEnabled(true);
        }
    }
    
    public String getMerkki() {
        return this.merkki;
    }

}

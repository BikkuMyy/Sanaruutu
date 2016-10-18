package sanapeli.kayttoliittyma;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import sanapeli.logiikka.Pelilogiikka;

/**
 * Luokka sisältää yhteen nappiin liittyvät tiedot ja metodit niiden
 * käsittelemiseen.
 *
 */
public class MerkkiNappi extends JButton {

    private Pelilogiikka logiikka;
    private String merkki;
    private int y;
    private int x;

    /**
     * Konstruktori.
     *
     * @param y napin y-koordinaatti
     * @param x napin x-koordinaatti
     * @param logiikka Pelilogiikka-rajapinnan ilmentymä
     */
    public MerkkiNappi(int y, int x, Pelilogiikka logiikka) {
        this.logiikka = logiikka;
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
        super.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        tarkistaAktiivisuus();
    }

    private String haeNappiinMerkkiRuudusta() {
        return logiikka.getRuudukko()[y][x].toString();
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

    public Pelilogiikka getLogiikka() {
        return logiikka;
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
